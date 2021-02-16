package com.gt.gtadmin.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>@Configuration 配置类注解：表示这是一个配置类</p>
 * <p>@EnableTransactionManagement 自动管理事务</p>
 * <p>@MapperScan("com.mybatisplus.mapper") 扫描 mapper 文件夹下的文件</p>
 *
 * @Author Zz
 * @Date 2021/2/15 17:25
 */
@MapperScan("com.gt.gtadmin.mapper")
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig implements WebMvcConfigurer {
    /**
     * 默认首页设置，当请求时项目地址的时候 返回login
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        //registry.addViewController("/index.html").setViewName("login");
        //registry.addViewController("/main.html").setViewName("dashboard");
    }
    /**
     * 注册乐观锁
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        /*
            PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
            // 设置请求的页面大于最大页后操作,true 调回到首页,false 继续请求 默认false
            // paginationInterceptor.setOverflow(false);
            // 设置最大单页限制数量,默认 500 条,-1不受限制
            // paginationInterceptor.setLimit(500);
            // 开启 count 的join优化,只针对部分left join
            paginationInterceptor.setCountSqlParser(new JsplParserCountOpimize(true));
            return paginationInterceptor;
        */
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * SQL执行效率
     * @return
     */
    @Bean
    @Profile({"dev","test"}) //设置dev,test 环境开启，保证我们的效率
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // 在工作中,不允许用户等待
        performanceInterceptor.setMaxTime(30000); // 设置sql执行最大时间,如果超过就不执行
        performanceInterceptor.setFormat(true); // 开启sql格式化
        return performanceInterceptor;
//        return new PerformanceInterceptor();
    }
}
