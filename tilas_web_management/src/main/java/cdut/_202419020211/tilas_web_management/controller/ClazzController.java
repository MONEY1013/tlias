package cdut._202419020211.tilas_web_management.controller;


import cdut._202419020211.tilas_web_management.pojo.Clazz;
import cdut._202419020211.tilas_web_management.pojo.PageResult;
import cdut._202419020211.tilas_web_management.pojo.Result;
import cdut._202419020211.tilas_web_management.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    /**
     * 分页查询班级列表
     */
    @GetMapping
    public Result pageList(@RequestParam(required = false) String name,
                           @RequestParam(required = false) Date begin,
                           @RequestParam(required = false) Date end,
                           @RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int pageSize) {
        log.info("查询班级列表,参数: name={}, begin={}, end={}, page={}, pageSize={}", name, begin, end, page, pageSize);
        PageResult pageResult = clazzService.pageList(name, begin, end, page, pageSize);
        return Result.success(pageResult);
    }

    /*
    * 根据id查询班级
    * */
    @GetMapping("/{id}")
    public Result getClazz(@PathVariable int id) {
        Clazz clazz = clazzService.getClazz(id);
        return Result.success(clazz);
    }

    /*
    * 新增班级
    * */
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        clazzService.addClazz(clazz);
        return Result.success();
    }

    /*
    * 删除班级
    * */
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Long id) {
        clazzService.deleteClazz(id);
        return Result.success();
    }

    /**
     * 更新班级
     */
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        clazzService.updateClazz(clazz);
        return Result.success();
    }
}
