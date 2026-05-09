package cdut._202419020211.tilas_web_management.service.impl;

import cdut._202419020211.tilas_web_management.mapper.ClazzMapper;
import cdut._202419020211.tilas_web_management.pojo.Clazz;
import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClazzServiceimpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    /*
    * 分页查询班级列表
    * */
    @Override
    public PageResult pageList(String name, Date begin, Date end, int page, int pageSize) {
        Long total = clazzMapper.count(name, begin, end);
        List<Clazz> clazzList = clazzMapper.pageList(name, begin, end, (page - 1) * pageSize, pageSize);
        return new PageResult(total, clazzList);
    }
    /*
    * 新增班级
    * */
    @Override
    public void addClazz(Clazz clazz) {
        clazzMapper.insert(clazz);
    }
    /*
    * 删除班级
    * */
    @Override
    public void deleteClazz(Long id) {
        clazzMapper.deleteById(id);
    }
    /*
    * 根据id查询班级
    * */
    @Override
    public Clazz getClazz(int id) {
        return clazzMapper.selectById(id);
    }
    /*
    * 更新班级
    * */
    @Override
    public void updateClazz(Clazz clazz) {
        clazzMapper.updateById(clazz);
    }
}
