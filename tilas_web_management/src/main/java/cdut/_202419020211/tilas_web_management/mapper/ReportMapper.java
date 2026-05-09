package cdut._202419020211.tilas_web_management.mapper;


import cdut._202419020211.tilas_web_management.pojo.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.Map;

import java.util.List;

@Component
@Mapper
public interface ReportMapper {

    @Select("select count(*) as value from emp where gender = 1")
    Count empGenderManData();
    @Select("select count(*) as value from emp where gender = 2")
    Count empGenderWomanData();

    @Select("SELECT d.name AS deptName, COUNT(e.id) AS value FROM emp e JOIN dept d ON e.dept_id = d.id GROUP BY d.name")
    List<Map<String, Object>> empDeptData();

    @Select("SELECT \r\n" + 
                "  CASE degree\r\n" + 
                "    WHEN 1 THEN '初中'\r\n" + 
                "    WHEN 2 THEN '高中'\r\n" + 
                "    WHEN 3 THEN '大专'\r\n" + 
                "    WHEN 4 THEN '本科'\r\n" + 
                "    WHEN 5 THEN '硕士'\r\n" + 
                "    WHEN 6 THEN '博士'\r\n" + 
                "  END AS name,\r\n" + 
                "  COUNT(*) AS value \r\n" + 
                "FROM student \r\n" + 
                "GROUP BY degree")
    List<Count> studentDegreeData();
}