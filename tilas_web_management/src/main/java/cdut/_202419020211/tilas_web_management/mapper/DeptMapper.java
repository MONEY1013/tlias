package cdut._202419020211.tilas_web_management.mapper;

import cdut._202419020211.tilas_web_management.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name,createTime,updateTime) values(#{deptName},now(),now())")
    void add(String deptName);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name} where id = #{id}")
    void update(Integer id, String name);
}