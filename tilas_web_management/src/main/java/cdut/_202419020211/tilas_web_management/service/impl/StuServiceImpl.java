package cdut._202419020211.tilas_web_management.service.impl;

import cdut._202419020211.tilas_web_management.mapper.StuMapper;
import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.pojo.Student;
import cdut._202419020211.tilas_web_management.service.StuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    StuMapper stuMapper;
    /**
     * 分页查询学生列表
     */
    @Override
    public PageResult pageList(String name, Integer clazzId, Integer degree, int page, int pageSize) {
        Long total = stuMapper.count(name, clazzId, degree);
        List<Student> rows = stuMapper.pageList(name, clazzId, degree, (page - 1) * pageSize, pageSize);
        return new PageResult(total, rows);
    }
    /**
     * 新增学生
     */
    @Override
    public void save(Student student) {
        stuMapper.save(student);
    }
    /**
     * 删除学生
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            stuMapper.delete(id);
        }
    }

    @Override
    public Student get(Integer id) {
        return stuMapper.get(id);
    }

    @Override
    public void update(Student student) {
        stuMapper.update(student);
    }

    @Override
    public void violation(Integer id, Integer score) {
        stuMapper.violation(id, score);
    }
}
