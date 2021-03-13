package com.webdev.bootweb.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> headers,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-f82be3f5") String cookie1,
                                     @CookieValue("Idea-f82be3f5") Cookie cookie){
        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("headers",headers);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("Idea-f82be3f5",cookie1);
        System.out.println(cookie);
        return map;
    }

    @PostMapping("/save")
    public Map PostMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;

    }
}
