package cdut._202419020211.tilas_web_management.controller;


import cdut._202419020211.tilas_web_management.pojo.Result;
import cdut._202419020211.tilas_web_management.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 员工性别数据
     */
    @GetMapping("/empGenderData")
    public Result empGenderData() {
        return Result.success(reportService.empGenderData());
    }

    /**
     * 员工部门数据
     */
    @GetMapping("/empDeptData")
    public Result empDeptData() {
        return Result.success(reportService.empDeptData());
    }

    /**
     * 学生学历数据
     */
    @GetMapping("/studentDegreeData")
    public Result studentDegreeData() {
        return Result.success(reportService.studentDegreeData());
    }
}
