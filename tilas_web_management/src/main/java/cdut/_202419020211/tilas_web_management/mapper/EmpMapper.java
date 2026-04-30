package cdut._202419020211.tilas_web_management.mapper;

import cdut._202419020211.tilas_web_management.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Delete("delete from emp where id = #{id}")
    void delete(Integer id);

    @Insert("insert into emp(name,gender,dept_id,job,entry_date,avatar,create_time,update_time) values(#{name},#{gender},#{deptId},#{job},#{entryDate},#{avatar},now(),now())")
    void save(String name, String gender, Integer deptId, String job, Date entryDate, String avatar);
}