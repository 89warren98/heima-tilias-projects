package TliasProject.Configuers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import TliasProject.Interceptors.LoginInterceptors;

/*
 * author: Warren
 */
@Configuration //配置类注解
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptors loginInterceptors;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptors).addPathPatterns("/**"); // 拦截路径,拦截所有请求
    }
}