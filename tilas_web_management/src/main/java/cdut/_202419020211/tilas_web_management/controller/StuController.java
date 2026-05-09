package cdut._202419020211.tilas_web_management.controller;


import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.pojo.Result;
import cdut._202419020211.tilas_web_management.pojo.Student;
import cdut._202419020211.tilas_web_management.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StuController {
    @Autowired
    StuService stuService;
    /**
     * 分页查询学生列表
     */
    @GetMapping
    public Result pageList(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int pageSize,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) Integer clazzId,
                           @RequestParam(required = false) Integer degree) {
        PageResult pageResult = stuService.pageList(name, clazzId, degree, page, pageSize);
        return Result.success(pageResult);
    }
    /**
     * 新增学生
     */
    @PostMapping
    public Result add(@RequestBody Student student) {
        stuService.save(student);
        return Result.success();
    }


    /**
     * 删除学生(批量删除)
     */
    @DeleteMapping
    public Result delete(@RequestParam Integer[] ids) {
        stuService.delete(ids);
        return Result.success();
    }

    /*
    * 根据id查询学生详情
    * */
    @GetMapping("/{id}")
    public Result update(@PathVariable Integer id) {
        return Result.success(stuService.get(id));
    }

    /**
     * 更新学生
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        stuService.update(student);
        return Result.success();
    }

    /*
    * 违纪处理
    * */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        stuService.violation(id, score);
        return Result.success();
    }
}

