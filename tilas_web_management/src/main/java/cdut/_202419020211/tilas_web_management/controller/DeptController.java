package cdut._202419020211.tilas_web_management.controller;


import cdut._202419020211.tilas_web_management.pojo.Dept;
import cdut._202419020211.tilas_web_management.pojo.Result;
import cdut._202419020211.tilas_web_management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
@CrossOrigin(origins = "*")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     */
    @GetMapping
    public Result findAll() {
        List<Dept> depts = deptService.findAll();
        Result result = Result.success(depts);
        result.setData(depts);
        result.setCode(1);
        result.setMessage("success");
        return result;
    }

    /**
     * 删除部门
     */
    @DeleteMapping
    public Result deleteById(@RequestParam Integer id) {
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept.getName());
        return Result.success();
    }

    /**
     * 按照ID查询部门详情
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 更新部门信息
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept.getId(),dept.getName());
        return Result.success();
    }
}