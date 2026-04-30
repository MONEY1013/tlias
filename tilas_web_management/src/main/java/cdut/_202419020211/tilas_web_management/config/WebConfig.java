package cdut._202419020211.tilas_web_management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源映射
        registry.addResourceHandler("/imgs/**")
                .addResourceLocations("classpath:/imgs/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
