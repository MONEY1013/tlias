package cdut._202419020211.tilas_web_management.mapper;


import cdut._202419020211.tilas_web_management.pojo.Clazz;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
@Mapper
public interface ClazzMapper {

    /*
    * 分页查询班级列表
    * */
    List<Clazz> pageList(String name, Date begin, Date end, int offset, int size);
    Long count(String name, Date begin, Date end);

    /*
    * 新增班级
    * */
    @Insert("insert into clazz(name, begin_date, end_date,master_id,room,subject," +
            "create_time,update_time)  values(#{name}, #{beginDate}, #{endDate}," +
            " #{masterId}, #{room}, #{subject},now(),now())")
    void insert(Clazz clazz);


    /**
     * 删除班级
     */
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Long id);


    /**
     * 根据id查询班级
     */
    @Select("select * from clazz where id = #{id}")
    Clazz selectById(int id);

    /**
     * 更新班级
     */
    @Update("update clazz set name = #{name}, begin_date = #{beginDate}, end_date = #{endDate}, master_id = #{masterId}, room = #{room}, subject = #{subject} where id = #{id}")
    void updateById(Clazz clazz);
}
