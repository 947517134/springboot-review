package com.boot.admin.controller;

import com.boot.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 登录成功后重定向到
     * @param user
     * @param session
     * @return  登录成功后重定向到index.html防止表单重复提交
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword()) ) {
            //把登录成功的用户保存
            session.setAttribute("loginUser", user);
            return "redirect:/index.html";
        }else {
            //回到登录页面
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/index.html")
    public String mainPage(HttpSession session, Model model){
        //是否登录  经过修改可以通过拦截器实现
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//            return "index";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "index";
    }
}
