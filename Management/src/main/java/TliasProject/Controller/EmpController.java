package TliasProject.Controller;

import TliasProject.Anno.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import TliasProject.POJO.Emp;
import TliasProject.POJO.PageBean;
import TliasProject.POJO.Result;
import TliasProject.Service.EmpService;

import java.time.LocalDate;
import java.util.List;

/*
 * author: Warren
 */
@Slf4j//记录日志的注解
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired private EmpService empService;

    //分页查询
    @GetMapping
    public Result rows(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){

        log.info("分页查询,参数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pagebean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pagebean);
    }

    //删除操作
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("执行删除操作,ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    //添加操作
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加员工操作,emp;{}",emp);
        empService.add(emp);
    return Result.success();
    }

//    查询回显
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id查询:{}",id);
        Emp emp = empService.selectById(id);

        return Result.success(emp);
    }
    //修改员工
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改部门:{}", emp);
        //调用service修改部门
        empService.update(emp);
        return Result.success();
    }

}
