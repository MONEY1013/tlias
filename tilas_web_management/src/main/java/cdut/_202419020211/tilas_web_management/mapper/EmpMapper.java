package cdut._202419020211.tilas_web_management.mapper;

import cdut._202419020211.tilas_web_management.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
    Long count();

    @Select("select emp.id,emp.name,emp.gender,emp.avatar,dept.name as deptName,emp.job,emp.entry_date as entryDate,emp.update_time as updateTime\n" +
            "            from emp left join dept on emp.dept_id = dept.id limit #{page}, #{size}")
    List<Emp> page(Integer page, Integer size);
}