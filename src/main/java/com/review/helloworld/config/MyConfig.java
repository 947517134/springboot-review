package com.review.helloworld.config;

import ch.qos.logback.core.db.DBHelper;
import com.review.helloworld.pojo.Pet;
import com.review.helloworld.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethod: 代理bean的方法
 *      Full(proxyBeanMethod = true) 【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethod = false) 【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用FFull模式默认
 */


@Import({User.class, DBHelper.class})
@Configuration //告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次，获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean //给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01(){
        return new User("jason",23);
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

}
