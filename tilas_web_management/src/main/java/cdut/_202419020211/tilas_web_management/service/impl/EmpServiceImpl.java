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
    public PageResult page(Integer page, Integer size) {
        Long total = empMapper.count();
        List<Emp> rows = empMapper.page((page - 1) * size, size);
        return new PageResult(total, rows);
    }
}