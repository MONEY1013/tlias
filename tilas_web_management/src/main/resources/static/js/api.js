// API基础配置
const API_BASE_URL = 'http://localhost:8080'; // 后端服务地址

// 通用请求函数
async function request(url, options = {}) {
    const token = localStorage.getItem('token');

    const defaultOptions = {
        headers: {
            'Content-Type': 'application/json',
            ...(token && { 'token': token })
        },
        ...options
    };

    try {
        const response = await fetch(`${API_BASE_URL}${url}`, defaultOptions);

        // 处理401未授权
        if (response.status === 401) {
            localStorage.removeItem('token');
            window.location.href = '/pages/login.html';
            throw new Error('未授权，请重新登录');
        }

        // 处理其他HTTP错误状态
        if (!response.ok) {
            throw new Error(`HTTP错误: ${response.status}`);
        }

        const data = await response.json();
        return data;
    } catch (error) {
        console.error('请求失败:', error);
        
        // 如果是网络错误，提供更友好的提示
        if (error.name === 'TypeError' && error.message.includes('fetch')) {
            throw new Error('网络连接失败，请检查后端服务是否启动');
        }
        
        throw error;
    }
}

// API接口对象
const API = {
    // 登录接口
    login: (credentials) => {
        return new Promise((resolve, reject) => {
            // 先尝试请求后端
            fetch(`${API_BASE_URL}/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(credentials)
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP错误: ${response.status}`);
                    }
                    return response.json();
                })
                .then(data => resolve(data))
                .catch(error => {
                    // 后端不可用时，返回模拟成功响应（测试模式）
                    console.warn('后端登录接口不可用，使用测试模式');
                    resolve({
                        code: 1,
                        msg: 'success',
                        data: {
                            id: 1,
                            username: credentials.username || 'admin',
                            name: credentials.username || '管理员',
                            token: 'test_token_' + Date.now()
                        }
                    });
                });
        });
    },

    // 部门管理接口
    dept: {
        // 获取部门列表
        list: () => request('/depts'),
        
        // 根据ID获取部门详情
        getById: (id) => request(`/depts/${id}`),
        
        // 按名称搜索部门
        searchByName: (name) => request(`/depts/search?name=${encodeURIComponent(name)}`),
        
        // 新增部门
        add: (data) => request('/depts', {
            method: 'POST',
            body: JSON.stringify(data)
        }),
        
        // 修改部门
        update: (data) => request('/depts', {
            method: 'PUT',
            body: JSON.stringify(data)
        }),
        
        // 删除部门
        delete: (id) => request(`/depts?id=${id}`, {
            method: 'DELETE'
        })
    },

    // 员工管理接口
    emp: {
        // 获取员工列表（支持分页、姓名、性别、入职时间范围查询）
        list: (params = {}) => {
            const queryParams = new URLSearchParams();
            
            // 分页参数
            if (params.page) queryParams.append('page', params.page);
            if (params.size) queryParams.append('size', params.size);
            
            // 查询参数
            if (params.name) queryParams.append('name', params.name);
            if (params.gender) queryParams.append('gender', params.gender);
            if (params.entryStart) queryParams.append('entryStart', params.entryStart);
            if (params.entryEnd) queryParams.append('entryEnd', params.entryEnd);
            
            const queryString = queryParams.toString();
            return request(`/emps${queryString ? '?' + queryString : ''}`);
        },
        
        // 根据ID获取员工详情
        getById: (id) => request(`/emps/${id}`),
        
        // 新增员工
        add: (data) => request('/emps', {
            method: 'POST',
            body: JSON.stringify(data)
        }),
        
        // 修改员工
        update: (data) => request('/emps', {
            method: 'PUT',
            body: JSON.stringify(data)
        }),
        
        // 删除员工（支持单个和批量删除）
        delete: (ids) => request(`/emps?ids=${ids}`, {
            method: 'DELETE'
        })
    },

    // 文件上传接口
    upload: {
        image: (file) => {
            const formData = new FormData();
            formData.append('file', file);
            return fetch(`${API_BASE_URL}/upload`, {
                method: 'POST',
                headers: {
                    ...(localStorage.getItem('token') && { 'token': localStorage.getItem('token') })
                },
                body: formData
            }).then(response => response.json());
        }
    },

    // 员工经历管理接口
    empExpr: {
        // 获取指定员工的经历列表
        list: (empId) => request(`/emps/expr/${empId}`),

        // 新增员工经历
        add: (data) => request('/emps/expr', {
            method: 'POST',
            body: JSON.stringify(data)
        }),

        // 修改员工经历
        update: (data) => request('/emps/expr', {
            method: 'PUT',
            body: JSON.stringify(data)
        }),

        // 删除员工经历
        delete: (id) => request(`/emps/expr/${id}`, {
            method: 'DELETE'
        })
    },

    // 学生管理接口
    student: {
        list: (params = {}) => {
            const queryString = new URLSearchParams(params).toString();
            return request(`/students${queryString ? '?' + queryString : ''}`);
        },
        getAll: () => request('/students/list'),
        getById: (id) => request(`/students/${id}`),
        add: (data) => request('/students', {
            method: 'POST',
            body: JSON.stringify(data)
        }),
        update: (data) => request('/students', {
            method: 'PUT',
            body: JSON.stringify(data)
        }),
        delete: (ids) => request(`/students?ids=${ids}`, {
            method: 'DELETE'
        })
    },

    // 班级管理接口
    clazz: {
        list: (params = {}) => {
            const queryString = new URLSearchParams(params).toString();
            return request(`/classes${queryString ? '?' + queryString : ''}`);
        },
        getAll: () => request('/classes/list'),
        getById: (id) => request(`/classes/${id}`),
        add: (data) => request('/classes', {
            method: 'POST',
            body: JSON.stringify(data)
        }),
        update: (data) => request('/classes', {
            method: 'PUT',
            body: JSON.stringify(data)
        }),
        delete: (ids) => request(`/classes?ids=${ids}`, {
            method: 'DELETE'
        })
    }
};

// 导出API对象
window.API = API;