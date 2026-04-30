package cdut._202419020211.tilas_web_management.controller;


import cdut._202419020211.tilas_web_management.pojo.Emp;
import cdut._202419020211.tilas_web_management.pojo.EmpResult;
import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.pojo.Result;
import cdut._202419020211.tilas_web_management.service.EmpService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    /*
     * 分页查询员工列表
     * 方法一：传统方法
     * 请求路径：/emps
     * 请求方法：GET
     * 请求参数：page，pageSize
     */
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        log.info("page:{}, size:{}", page, size);
        PageResult pageResult = empService.page(page, size);
        return Result.success(pageResult);
    }

    /*
     * 删除员工
     * 请求路径：/emps
     * 请求方法：DELETE
     * 请求参数：ids（数组）
     * */
    @DeleteMapping
    public Result delete(@RequestParam Integer[] ids) {
        empService.delete(ids);
        return Result.success();
    }


    /*
     * 添加员工
     * 请求路径：/emps
     * 请求方法：POST
     * 请求参数：json格式
     * */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        emp.setAvatar("/imgs/01.png");
        empService.save(emp.getName(), emp.getGender(), emp.getDeptId(), emp.getJob(), emp.getEntryDate(), emp.getAvatar());
        return Result.success();
    }
}
