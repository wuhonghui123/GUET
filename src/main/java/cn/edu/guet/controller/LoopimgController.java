package cn.edu.guet.controller;

import cn.edu.guet.bean.Loopimg;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoopimgController {



    @RequestMapping("/getLoopimgList")// 相当于之前在web.xml中的url-pattern的内容
    public List<Loopimg> getLoopimgList() {
        System.out.println("获取轮播图");
        return null;
    }
}
