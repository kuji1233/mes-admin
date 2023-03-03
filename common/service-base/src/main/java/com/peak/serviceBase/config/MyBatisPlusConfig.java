package com.peak.serviceBase.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @ClassName : MyBatisPlusConfig
 * @Author : Administrator
 * @Date: 2023/02/08 12:40
 * @Description : MybatisPlus配置
 */
@Configuration  //配置类
@EnableTransactionManagement  //事务管理器
@MapperScan("com.peak.configurationCenter.mapper") //公共的mapperScan ,可以多个模块扫描
public class MyBatisPlusConfig {

    /**
     * //分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * //乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * //逻辑删除组件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }



}
