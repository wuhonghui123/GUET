package cn.edu.guet.controller;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private IUserService userServiceImpl;


    @RequestMapping("/login")
    public User login(String username, String password) {

        User user = userServiceImpl.login(username, password);
        System.out.println(user);
        return user;// 返回的JSON数据
    }

    @RequestMapping("/getUserPermission")// 相当于之前在web.xml中的url-pattern的内容
    public List<Permission> getUserPermission(String userId) {

        return userServiceImpl.getMenuByUserId(userId);
    }
}
