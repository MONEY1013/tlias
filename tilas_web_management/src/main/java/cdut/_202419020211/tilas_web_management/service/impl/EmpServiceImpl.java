package cdut._202419020211.tilas_web_management.service.impl;

import cdut._202419020211.tilas_web_management.mapper.EmpMapper;
import cdut._202419020211.tilas_web_management.pojo.Emp;
import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            empMapper.delete(id);
        }
    }

    @Override
    public void save(String name, String gender, Integer deptId, String job, Date entryDate,String avatar) {
        empMapper.save(name,gender,deptId,job,entryDate,avatar);
    }

    @Override
    public Emp getName(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }

    @Override
    public PageResult page(Integer page, Integer size, String name, String gender, Date entryStart, Date entryEnd) {
        Long total = empMapper.count(name, gender, entryStart, entryEnd);
        List<Emp> rows = empMapper.page((page - 1) * size, size, name, gender, entryStart, entryEnd);
        return new PageResult(total, rows);
    }
}