/*
 * author: Warren
 */
package TliasProject.Controller;

import TliasProject.Anno.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import TliasProject.POJO.Dept;
import TliasProject.POJO.Result;
import TliasProject.Service.DeptService;

import java.util.List;

@Slf4j//记录日志的注解
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired//依赖注入
    private DeptService deptService;

    //查询
    @GetMapping//指定请求方式为get,请求路径为depts;
    public Result list() {
        log.info("查询所有部门信息");
        List<Dept> list = deptService.list();
        return Result.success(list);
    }

    //删除
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门信息", id);
        deptService.delete(id);
        return Result.success();
    }

    //添加,虽然说前端只需要展示部门名称,但是还是要补全信息(setCreateTime和setUpdateTime)
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门", dept);

        deptService.add(dept);
        return Result.success();
    }

    // 修改部门信息
    @Log
    @GetMapping("/{id}")

    public Result getById(@PathVariable Integer id) {

        log.info("根据id查找部门:{}", id);
        //调用service查找部门
        Dept dept =deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result modify(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);
        //调用service修改部门
        deptService.modify(dept);
        return Result.success();
    }
}
