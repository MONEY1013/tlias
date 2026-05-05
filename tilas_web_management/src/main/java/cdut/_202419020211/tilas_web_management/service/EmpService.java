package cdut._202419020211.tilas_web_management.service;

import cdut._202419020211.tilas_web_management.pojo.Emp;
import cdut._202419020211.tilas_web_management.pojo.PageResult;

import java.util.Date;
import java.util.List;

public interface EmpService {

    void delete(Integer[] ids);

    void save(String name, String gender, Integer deptId, String job, Date entryDate,String avatar);

    Object getName(Integer id);

    void update(Emp emp);

    PageResult page(Integer page, Integer size, String name, String gender, Date entryStart, Date entryEnd);
}
