package com.edu.springsecurity.customlogin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //开启webmvc
@ComponentScan(basePackages = "com.edu.springsecurity.customlogin") //扫描相应的包
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {
    /**
     * ViewResovler，将拼接视图逻辑名称转为物理视图
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }

    /**
     * 上面的代码，如同spring xml文件的内容一样，配置如下：
     *  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     *         <!-- 需要引入jstl的相关jar包，jstl1.2以下需要引入jstl.jar、standard.jar -->
     *         <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
     *         <property name="prefix" value="/WEB-INF/jsp/"/>
     *         <property name="suffix" value=".jsp"/>
     *     </bean>
     *
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * 使用标签mvc:resources来制定
     * <mvc:resources location="/" mapping="*.js"></mvc:resources>
     */
}