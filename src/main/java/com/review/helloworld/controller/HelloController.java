package com.review.helloworld.controller;

import com.review.helloworld.pojo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j      //日志
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }


    //接口：http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        log.info("请求进来了");
        //调用业务，接收前端的参数
        return "helloworld";
    }
}
