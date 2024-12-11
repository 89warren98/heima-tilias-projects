package TliasProject.Interceptors;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import TliasProject.POJO.Result;
import TliasProject.Utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * author: Warren
 */
@Component
@Slf4j
public class LoginInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        //获取请求url
        String url = request.getRequestURL().toString();
        log.info("请求的url:{}",url);

        //判断请求路径是否包含login
        if(url.contains("login")){
            log.info("执行登录操作");

            return true;//不再执行下面的代码
        }

        //如果不是登录操作,获取令牌
        String jwt = request.getHeader("token");

        //判断jwt令牌是否存在
        if(!(StringUtils.hasLength(jwt))) {
            log.info("请求头token为空");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }

        //解析jwt令牌,如果解析失败,返回未登录
        try{
            JwtUtils.parseJWT(jwt);
        } catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }

        //放行
        log.info("令牌合法,放行");
        return true;



    }
}
