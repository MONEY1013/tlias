package cdut._202419020211.tilas_web_management.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;         // 员工ID
    private String name;        // 员工姓名
    private String gender;      // 员工性别
    private String avatar;      // 员工头像
    private Integer deptId;     // 员工部门ID
    private String job;         // 员工职务
    private Integer salary;     // 员工工资
    private Date entryDate;   // 员工入职日期
    private Date createTime;  // 员工创建时间
    private Date updateTime;  // 员工更新时间
    private String deptName;  // 员工部门名称


    // 员工工作经历列表
    private List<EmpExpr> exprExprList;
}
