package cdut._202419020211.tilas_web_management.service.impl;


import cdut._202419020211.tilas_web_management.mapper.ReportMapper;
import cdut._202419020211.tilas_web_management.pojo.Count;
import cdut._202419020211.tilas_web_management.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Count> empGenderData() {
        Count genderCountMan = reportMapper.empGenderManData();
        genderCountMan.setName("男");
        Count genderCountWoman = reportMapper.empGenderWomanData();
        genderCountWoman.setName("女");
        return List.of(genderCountMan, genderCountWoman);
    }

    @Override
    public Map<String, Object> empDeptData() {
        List<Map<String, Object>> list = reportMapper.empDeptData();

        List<String> deptList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();

        for (Map<String, Object> item : list) {
            deptList.add((String) item.get("deptName"));
            dataList.add(((Number) item.get("value")).intValue());
        }

        Map<String, Object> result = new HashMap<>();
        result.put("deptList", deptList);
        result.put("dataList", dataList);
        return result;
    }

    @Override
    public List<Count> studentDegreeData() {
        return reportMapper.studentDegreeData();
    }
}
