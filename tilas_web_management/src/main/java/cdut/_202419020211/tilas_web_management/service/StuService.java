package cdut._202419020211.tilas_web_management.service;

import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface StuService {
    PageResult pageList(String name, Integer clazzId, Integer degree, int page, int pageSize);

    void save(Student student);

    void delete(Integer[] ids);

    Object get(Integer id);

    void update(Student student);

    void violation(Integer id, Integer score);
}
