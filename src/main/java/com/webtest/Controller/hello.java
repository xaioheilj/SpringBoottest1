package com.webtest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.Map;


    @Controller
    public class hello {

//    @RequestMapping({"/","/login"})
//    public String login(){
//        return "login";
//    }



        @RequestMapping("/hello")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好<h1>");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "firstPage";
    }
}
