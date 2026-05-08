package cdut._202419020211.tilas_web_management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {

    private Integer id;
    private Integer empId;
    private String company;
    private String exprJob;
    private Date entryDate;
    private Date endDate;
    private String position;
}
