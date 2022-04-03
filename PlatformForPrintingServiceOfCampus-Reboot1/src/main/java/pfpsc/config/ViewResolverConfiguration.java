package pfpsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
/**
 * 主要配置多视图实现的视图解析器相关bean实例,将该视图解析器注册到容器中
 * <p>
 * <p>
 * 其实关键点在于两个：
 * 1、配置order属性
 * 2、配置viewnames属性
 */
@Configuration
public class ViewResolverConfiguration {
 
    @Bean
    public InternalResourceViewResolver htmlViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        viewResolver.setSuffix(".html");
        viewResolver.setOrder(0);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }
 
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(0);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }
 
}