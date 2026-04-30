package cdut._202419020211.tilas_web_management.service;

import cdut._202419020211.tilas_web_management.pojo.Emp;
import cdut._202419020211.tilas_web_management.pojo.PageResult;

import java.util.Date;
import java.util.List;

public interface EmpService {
    PageResult page(Integer page, Integer pageSize);

    void delete(Integer[] ids);

    void save(String name, String gender, Integer deptId, String job, Date entryDate,String avatar);
}
