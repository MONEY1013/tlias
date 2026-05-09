package cdut._202419020211.tilas_web_management.service;

import cdut._202419020211.tilas_web_management.pojo.Count;


import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Count> empGenderData();

    Map<String, Object> empDeptData();


    List<Count> studentDegreeData();
}
