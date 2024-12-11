package TliasProject.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import TliasProject.POJO.Emp;
import TliasProject.POJO.Result;
import TliasProject.Service.EmpService;
import TliasProject.Utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

/*
 * author: Warren
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("login emp:{}", emp);
        Emp e = empService.login(emp);
        if(e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String s = JwtUtils.generateJwt(claims);
            return Result.success(s);
        }
        return Result.error("用户名或密码错误");
    }
}
