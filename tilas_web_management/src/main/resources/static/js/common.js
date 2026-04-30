// 工具函数
const Utils = {
    // 格式化日期
    formatDate: (dateStr) => {
        if (!dateStr) return '-';
        try {
            const date = new Date(dateStr);
            return date.toLocaleDateString('zh-CN');
        } catch (error) {
            console.error('日期格式化错误:', error);
            return '-';
        }
    },

    // 格式化日期时间
    formatDateTime: (dateStr) => {
        if (!dateStr) return '-';
        try {
            const date = new Date(dateStr);
            return date.toLocaleString('zh-CN');
        } catch (error) {
            console.error('日期时间格式化错误:', error);
            return '-';
        }
    },

    // 性别映射
    genderMap: { 1: '男', 2: '女' },
    getGender: (gender) => Utils.genderMap[gender] || '-',

    // 显示消息提示
    showMessage: (message, type = 'info') => {
        // 移除现有的消息
        const existingMessages = document.querySelectorAll('.custom-alert');
        existingMessages.forEach(msg => msg.remove());

        const messageDiv = document.createElement('div');
        messageDiv.className = `custom-alert alert-${type}`;
        messageDiv.innerHTML = `
            <div style="display: flex; align-items: center; gap: 8px;">
                <i class="fas ${type === 'success' ? 'fa-check-circle' : type === 'error' ? 'fa-exclamation-circle' : 'fa-info-circle'}"></i>
                <span>${message}</span>
            </div>
        `;
        
        messageDiv.style.cssText = `
            position: fixed;
            top: 20px;
            right: 20px;
            padding: 12px 20px;
            background: ${type === 'success' ? '#28a745' : type === 'error' ? '#dc3545' : type === 'warning' ? '#ffc107' : '#17a2b8'};
            color: white;
            border-radius: 8px;
            z-index: 9999;
            animation: slideInRight 0.3s ease;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
            min-width: 200px;
            max-width: 400px;
        `;
        
        document.body.appendChild(messageDiv);
        
        // 3秒后自动消失
        setTimeout(() => {
            if (messageDiv.parentNode) {
                messageDiv.style.animation = 'slideOutRight 0.3s ease';
                setTimeout(() => messageDiv.remove(), 300);
            }
        }, 3000);
        
        // 添加动画样式
        if (!document.querySelector('#alert-animations')) {
            const style = document.createElement('style');
            style.id = 'alert-animations';
            style.textContent = `
                @keyframes slideInRight {
                    from { 
                        opacity: 0;
                        transform: translateX(100%);
                    }
                    to { 
                        opacity: 1;
                        transform: translateX(0);
                    }
                }
                @keyframes slideOutRight {
                    from { 
                        opacity: 1;
                        transform: translateX(0);
                    }
                    to { 
                        opacity: 0;
                        transform: translateX(100%);
                    }
                }
            `;
            document.head.appendChild(style);
        }
    },

    // 确认对话框（美化版）
    confirm: (message) => {
        return new Promise((resolve) => {
            // 创建模态框
            const modal = document.createElement('div');
            modal.style.cssText = `
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(0,0,0,0.5);
                display: flex;
                align-items: center;
                justify-content: center;
                z-index: 10000;
                animation: fadeIn 0.3s ease;
            `;
            
            const content = document.createElement('div');
            content.style.cssText = `
                background: white;
                padding: 24px;
                border-radius: 12px;
                box-shadow: 0 10px 30px rgba(0,0,0,0.3);
                text-align: center;
                min-width: 300px;
                animation: slideInUp 0.3s ease;
            `;
            
            content.innerHTML = `
                <div style="margin-bottom: 20px;">
                    <i class="fas fa-exclamation-triangle" style="font-size: 48px; color: #ffc107; margin-bottom: 16px;"></i>
                    <h4 style="margin: 0 0 8px 0; color: #495057;">确认操作</h4>
                    <p style="margin: 0; color: #6c757d; line-height: 1.5;">${message}</p>
                </div>
                <div style="display: flex; gap: 12px; justify-content: center;">
                    <button class="btn btn-outline" id="confirm-cancel" style="min-width: 80px;">取消</button>
                    <button class="btn btn-primary" id="confirm-ok" style="min-width: 80px;">确定</button>
                </div>
            `;
            
            modal.appendChild(content);
            document.body.appendChild(modal);
            
            // 添加动画样式
            if (!document.querySelector('#confirm-animations')) {
                const style = document.createElement('style');
                style.id = 'confirm-animations';
                style.textContent = `
                    @keyframes fadeIn {
                        from { opacity: 0; }
                        to { opacity: 1; }
                    }
                    @keyframes slideInUp {
                        from { 
                            opacity: 0;
                            transform: translateY(20px);
                        }
                        to { 
                            opacity: 1;
                            transform: translateY(0);
                        }
                    }
                `;
                document.head.appendChild(style);
            }
            
            // 事件处理
            const handleConfirm = (result) => {
                modal.style.animation = 'fadeOut 0.3s ease';
                content.style.animation = 'slideOutDown 0.3s ease';
                setTimeout(() => {
                    if (modal.parentNode) {
                        modal.remove();
                    }
                }, 300);
                resolve(result);
            };
            
            document.getElementById('confirm-ok').onclick = () => handleConfirm(true);
            document.getElementById('confirm-cancel').onclick = () => handleConfirm(false);
            
            // 点击背景关闭
            modal.onclick = (e) => {
                if (e.target === modal) {
                    handleConfirm(false);
                }
            };
            
            // 添加关闭动画
            if (!document.querySelector('#confirm-close-animations')) {
                const closeStyle = document.createElement('style');
                closeStyle.id = 'confirm-close-animations';
                closeStyle.textContent = `
                    @keyframes fadeOut {
                        from { opacity: 1; }
                        to { opacity: 0; }
                    }
                    @keyframes slideOutDown {
                        from { 
                            opacity: 1;
                            transform: translateY(0);
                        }
                        to { 
                            opacity: 0;
                            transform: translateY(20px);
                        }
                    }
                `;
                document.head.appendChild(closeStyle);
            }
        });
    },

    // 获取查询参数
    getQueryParams: () => {
        const params = new URLSearchParams(window.location.search);
        const result = {};
        for (const [key, value] of params) {
            result[key] = value;
        }
        return result;
    },

    // 防抖函数
    debounce: (func, wait) => {
        let timeout;
        return function executedFunction(...args) {
            const later = () => {
                clearTimeout(timeout);
                func(...args);
            };
            clearTimeout(timeout);
            timeout = setTimeout(later, wait);
        };
    },

    // 节流函数
    throttle: (func, limit) => {
        let inThrottle;
        return function(...args) {
            if (!inThrottle) {
                func.apply(this, args);
                inThrottle = true;
                setTimeout(() => inThrottle = false, limit);
            }
        };
    },

    // 验证邮箱格式
    validateEmail: (email) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    },

    // 验证手机号格式
    validatePhone: (phone) => {
        const re = /^1[3-9]\d{9}$/;
        return re.test(phone);
    },

    // 生成随机ID
    generateId: () => {
        return Date.now().toString(36) + Math.random().toString(36).substr(2);
    }
};

// 组件加载器
async function loadComponent(containerId, componentPath) {
    try {
        const response = await fetch(componentPath);
        const html = await response.text();
        document.getElementById(containerId).innerHTML = html;
    } catch (error) {
        console.error('加载组件失败:', error);
    }
}

// 导出工具函数
window.Utils = Utils;
window.loadComponent = loadComponent;