package com.atguigu.thymeleaf.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Janty
 * @projectName: thymeleaf-demo
 * @date: 2023/3/10 22:55
 * @description:
 */
@Controller
public class IndexController {

    @GetMapping("index")
    public String index(HttpServletRequest request, Model model, HttpSession httpSession, HashMap hashMap){
        request.setAttribute("name","刘德华");

        List<String> list = Arrays.asList("郑爽", "刘德华", "张惠妹", "成龙");

        request.setAttribute("arrayList",list);

        model.addAttribute("age",18);

        httpSession.setAttribute("addr","北京中南海");

        request.setAttribute("gname","<span style=color:green>绿色</span>");

//        在index 控制器中先存储一个category1Id
        /*保存 category1Id*/
        request.setAttribute("category1Id","2");

        model.addAttribute("addr","北京昌平区");
        hashMap.put("id","101");

        HashMap<String, Object> map = new HashMap<>();
        map.put("stuNo","1000");
        map.put("stuName","张三");
        model.addAllAttributes(map);


        return "index";
    }

    @RequestMapping("list.html")
    @ResponseBody
    public String list(String category1Id){
        // 接收传递过来的数据
        System.out.println("获取到的数据：\t"+category1Id);
        return category1Id;
    }


}
