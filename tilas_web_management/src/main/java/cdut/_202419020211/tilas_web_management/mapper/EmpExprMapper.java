package cdut._202419020211.tilas_web_management.mapper;

import cdut._202419020211.tilas_web_management.pojo.EmpExpr;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmpExprMapper {

    /*
    * 展示员工工作经历
    * */
    @Select("select id,emp_id,company,position as exprJob,start_date as entryDate,end_date from emp_work_experience where emp_id = #{empId}")
    public List<EmpExpr> selectByEmpId(Integer empId);

    /*
    * 更新员工工作经历
    * */
    void updateExpr(EmpExpr expr);

    /*
    * 保存员工工作经历
    * */
    void saveEmpExpr(EmpExpr expr);

    /*
    * 批量保存员工工作经历
    * */
    void batchInsert(List<EmpExpr> list);

    /*
    * 删除员工工作经历
    * */
    @Delete("delete from emp_work_experience where id = #{id}")
    void deleteExprById(Integer id);
}
