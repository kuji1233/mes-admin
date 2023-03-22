package com.peak.serurity.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    // Shiro 需要的三个关键对象

    // 3.ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        // 创建 ShiroFilterFactoryBean对象
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 和 SecurityManager 关联起来
        bean.setSecurityManager(securityManager);

        /* 权限类别
         *  anon：无需认证即可访问
         *  authc：必须认证才可访问
         *  user：必须有 记住我 功能才能访问
         *  perms:拥有对某个资源的权限才能访问
         *  roles：拥有某个角色权限才能访问
         * */
        // 设置内置过滤器
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        // 和 Druid 监控设置一样，在 Map 中设置好权限
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        // 也可以使用通配符
        // filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        // 无权限前往登录页，同 SpringSecurity！
        bean.setLoginUrl("/toLogin");



        return bean;
    }
    // 2.DefaultWebSecurityManager 对应 SecurityManager
    @Bean(name="securityManager")
    // 将SecurityManager也交给Spring管理
    // @Qualifier 相当于形参上的@AutoWired
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")  UserRealm userRealm){
        //创建SecurityManager对象
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //和Realm关联起来，通过参数让Spring把Realm对象放进来
        securityManager.setRealm(userRealm);
        return securityManager;

    }
    // 1.创建 Realm 对象 需要自定义类 对应 Realm
    @Bean
    // @Bean 告诉 Spring，可以从这个方法中获取到一个对象，对象名就是方法名
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
