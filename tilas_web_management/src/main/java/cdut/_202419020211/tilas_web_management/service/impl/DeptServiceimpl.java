package cdut._202419020211.tilas_web_management.service.impl;

import cdut._202419020211.tilas_web_management.mapper.DeptMapper;
import cdut._202419020211.tilas_web_management.pojo.Dept;
import cdut._202419020211.tilas_web_management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class DeptServiceimpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void add(String deptName) {
        deptMapper.add(deptName);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Integer id, String name) {
        deptMapper.update(id,name);
    }
}