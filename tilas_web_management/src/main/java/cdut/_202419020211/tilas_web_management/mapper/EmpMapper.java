package cdut._202419020211.tilas_web_management.mapper;

import cdut._202419020211.tilas_web_management.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id = #{id}")
    void delete(Integer id);

    @Insert("insert into emp (name, gender, dept_id, job, entry_date, avatar, create_time, update_time) values (#{name}, #{gender}, #{deptId}, #{job}, #{entryDate}, #{avatar}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertEmp(Emp emp);

    @Select("select id,name,gender,avatar,dept_id,job,entry_date as entryDate,update_time as updateTime from emp where id = #{id}")
    Emp getById(Integer id);

    @Update("update emp set name = #{name}, gender = #{gender}, dept_id = #{deptId}, job = #{job}, entry_date = #{entryDate}, avatar = #{avatar}, update_time = now() where id = #{id}")
    void update(Emp emp);

    List<Emp> page(@Param("page") Integer page, @Param("size") Integer size,
                   @Param("name") String name, @Param("gender") String gender,
                   @Param("entryStart") Date entryStart, @Param("entryEnd") Date entryEnd);
    Long count(@Param("name") String name, @Param("gender") String gender,
               @Param("entryStart") Date entryStart, @Param("entryEnd") Date entryEnd);

}