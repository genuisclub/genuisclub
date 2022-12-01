package club.genuis.web.config;

import club.genuis.web.base.LoginInterceptor;
import com.btprice.middleware.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private RedisService redisService;
    @Value("${prod:true}")
    private boolean prod;

    private static final  String[] excludeUrls = {"/user/login","/user/register","/user/pwd/reset"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final LoginInterceptor loginInteceptor = new LoginInterceptor(redisService);
        loginInteceptor.setInvalid(prod);
        registry.addInterceptor(loginInteceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludeUrls);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:/app/html/images");
    }
}
