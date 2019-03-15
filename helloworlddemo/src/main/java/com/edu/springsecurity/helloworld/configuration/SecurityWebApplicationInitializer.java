package com.edu.springsecurity.helloworld.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
 
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    /**
     *等同于web.xml文件中的内容：
     *  <filter>
     *     <filter-name>springSecurityFilterChain</filter-name>
     *     <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
     * </filter>
     *
     * <filter-mapping>
     *     <filter-name>springSecurityFilterChain</filter-name>
     *     <url-pattern>/*</url-pattern>
     * </filter-mapping>
     */
}