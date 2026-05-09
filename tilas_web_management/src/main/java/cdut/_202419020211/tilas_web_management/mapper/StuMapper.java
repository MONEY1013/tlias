package cdut._202419020211.tilas_web_management.mapper;


import cdut._202419020211.tilas_web_management.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StuMapper {

    /**
     * 分页查询学生列表
     */
    Long count(String name, Integer clazzId, Integer degree);
    List<Student> pageList(String name, Integer clazzId, Integer degree, int offset, int size);

    /**
     * 新增学生
     */
    @Insert("insert into student (name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time) values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, 0, 0, now(),now())")
    void save(Student student);

    /**
     * 删除学生(批量删除)
     */
    @Delete("delete from student where id = #{id}")
    void delete(Integer id);
    /**
     * 根据id查询学生详情
     */
    @Select("select * from student where id = #{id}")
    Student get(Integer id);
    
    /**
     * 更新学生
     */
    @Update("update student set name = #{name}, no = #{no}, gender = #{gender}, phone = #{phone}, id_card = #{idCard}, is_college = #{isCollege}, address = #{address}, degree = #{degree}, graduation_date = #{graduationDate}, clazz_id = #{clazzId},update_time = now() where id = #{id}")
       void update(Student student);

    /**
     * 违纪处理
     */
    @Update("update student set violation_count =violation_count + 1, violation_score = violation_score + #{score} where id = #{id}")
    void violation(Integer id, Integer score);
}
