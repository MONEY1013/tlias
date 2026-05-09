package cdut._202419020211.tilas_web_management.service;

import cdut._202419020211.tilas_web_management.pojo.Clazz;
import cdut._202419020211.tilas_web_management.pojo.PageResult;

import java.util.Date;

public interface ClazzService {
    PageResult pageList(String name, Date begin, Date end, int page, int pageSize);

    void addClazz(Clazz clazz);

    void deleteClazz(Long id);

    Clazz getClazz(int id);

    void updateClazz(Clazz clazz);
}
