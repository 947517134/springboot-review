package com.boot.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.admin.bean.User;
import com.boot.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;


    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";

    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                Model model){
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan","123456"),
//                new User("jason","123"),
//                new User("admin","admin"));
//        model.addAttribute("users",users);

        //从数据库中查出user表中的用户进行展示
        List<User> list = userService.list();
//        model.addAttribute("users",list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);


        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
