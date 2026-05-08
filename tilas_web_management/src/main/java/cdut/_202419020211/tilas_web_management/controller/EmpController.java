package cdut._202419020211.tilas_web_management.controller;


import cdut._202419020211.tilas_web_management.pojo.*;
import cdut._202419020211.tilas_web_management.service.EmpService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String gender,
                       @RequestParam(required = false) Date entryStart,
                       @RequestParam(required = false) Date entryEnd) {
        PageResult pageResult = empService.page(page, size, name, gender, entryStart, entryEnd);
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
    @Transactional
    public Result save(@RequestBody Emp emp) {
        emp.setAvatar("/imgs/01.png");
        empService.save(emp);
        return Result.success();
    }

    /*
     * 查询员工详情
     * 请求路径：/emps/{id}
     * 请求方法：GET
     * 请求参数：id
     * */
    @GetMapping("/{id}")
    public Result getName(@PathVariable Integer id) {
        return Result.success(empService.getName(id));
    }

    /*
     * 更新员工
     * 请求路径：/emps
     * 请求方法：PUT
     * 请求参数：json格式
     * */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        if (emp.getAvatar() == null || emp.getAvatar().isEmpty()) {
            emp.setAvatar("/imgs/01.png");
        }
        empService.update(emp);

        return Result.success();
    }

    @GetMapping("/expr/{id}")
    public Result getExpr(@PathVariable Integer id) {
        return Result.success(empService.getExprExprList(id));
    }

    @PostMapping("/expr")
    public Result saveExpr(@RequestBody EmpExpr expr) {
        empService.saveEmpExpr(expr);
        return  Result.success();
    }

    @DeleteMapping("/expr/{id}")
    public Result delete(@PathVariable Integer id) {
        empService.deleteExprById(id);
        return Result.success();
    }

    @PutMapping("/expr")
    public Result updateExpr(@RequestBody EmpExpr expr) {
        empService.updateExpr(expr);
        return Result.success();
    }

}
