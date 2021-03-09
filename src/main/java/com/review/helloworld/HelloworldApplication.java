package com.review.helloworld;

import ch.qos.logback.core.db.DBHelper;
import com.review.helloworld.config.MyConfig;
import com.review.helloworld.pojo.Pet;
import com.review.helloworld.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//本身就是Spring的一个组件
//程序的主入口

/**
 * 主程序类
 * @SpringBootApplication ： 这是一个springboot应用
 */
@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(HelloworldApplication.class, args);

        //2.查看IOC容器中的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }

        //3.从容器中获取组件
        Pet tom1 = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);
        System.out.println("获取的两个组件是否是同一个组件:"+ (tom1==tom2));

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);


        /**
         * 如果@Configuration(proxyBeanMethod = true)代理对象调用方法，Springboot总会检查这个组件是否保持组件单实例
         */
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);


        //5。获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("==========");
        for(String s : beanNamesForType){
            System.out.println(s);
        }

        Object bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

    }

}
