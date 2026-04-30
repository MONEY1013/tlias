package cdut._202419020211.tilas_web_management.service;

import cdut._202419020211.tilas_web_management.mapper.DeptMapper;
import cdut._202419020211.tilas_web_management.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    void delete(Integer id);

    void add(String deptName);

    Dept getById(Integer id);

    void update(Integer id, String name);
}