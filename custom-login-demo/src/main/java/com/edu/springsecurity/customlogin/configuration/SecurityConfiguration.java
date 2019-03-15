package com.edu.springsecurity.customlogin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 使用用户凭证和允许的角色来配置AuthenticationManagerBuilder。AuthenticationManagerBuilder创建AuthenticationManager,AuthenticationManager用于处理认证请求。
     * 本实例中使用的是内存方式来存储用户的凭证信息和角色，也可以存储在JDBC，LDAP或者其他方式来获取。
     */
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
    }

    /**
     * HttpSecurity允许为特定http请求基于web安全性的配置。默认情况下，使用所有请求，可以使用requestMatcher/antMatchers
     * formLogin方法为基于表单的身份认证提供支持，并将生成一个要求用户凭证的默认表单。
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login") //设置自定义登陆页面
                .usernameParameter("username").passwordParameter("password")//设置要传过来的参数
                .and().csrf()
                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

    /**
     * https://blog.csdn.net/lemisky/article/details/78250830
     * https://blog.csdn.net/zknxx/article/details/78398261
     * https://blog.csdn.net/lemisky/article/details/78250830
     * https://www.cnblogs.com/xdp-gacl/p/4010328.html
     */
    /**
     * 等同于applicationContext-security.xml文件的内容：
     * <beans:beans xmlns="http://www.springframework.org/schema/security"
     *     xmlns:beans="http://www.springframework.org/schema/beans"
     *     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     *     xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
     *     http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-4.0.xsd">
     *
     *     <http auto-config="true" >
     *         <intercept-url pattern="/" access="permitAll" />
     *         <intercept-url pattern="/home" access="permitAll" />
     *         <intercept-url pattern="/admin**" access="hasRole('ADMIN')" />
     *         <intercept-url pattern="/dba**" access="hasRole('ADMIN') and hasRole('DBA')" />
     *         <form-login  login-page="/login" username-parameter="username" password-parameter="password" authentication-failure-url="/Access_Denied" />
     *         <csrf/>
     *     </http>
     *
     *     <authentication-manager >
     *         <authentication-provider>
     *             <user-service>
     *                 <user name="bill"  password="abc123"  authorities="ROLE_USER" />
     *                 <user name="admin" password="root123" authorities="ROLE_ADMIN" />
     *                 <user name="dba"   password="root123" authorities="ROLE_ADMIN,ROLE_DBA" />
     *             </user-service>
     *         </authentication-provider>
     *     </authentication-manager>
     *
     *
     * </beans:beans>
     */
}
