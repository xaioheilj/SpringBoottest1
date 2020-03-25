package com.webtest.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.SunHints;

import javax.servlet.http.HttpSession;
import java.util.Map;
import	java.util.ResourceBundle.Control;

@Controller
public class LoginController {
    //等价于@RequestMapping(value="/user/login",method=RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "12345".equals(password)){
            session.setAttribute("loginUser",username);
            //登录成功重定向，防止表单重复提交
            return "redirect:/main";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
