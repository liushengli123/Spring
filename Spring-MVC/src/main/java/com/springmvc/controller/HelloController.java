package com.springmvc.controller;


import com.springmvc.admin.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：
 * @date ：Created in 2019/12/1 11:11
 * @description ： controller
 */
//  handlerMapping 请求处理映射器  handlerAdapter 请求处理适配器
//      其主要就是通过requestmapping getmapping 等注解来实现
@Controller
public class HelloController {

//    返回字符串的方式进行页面响应
//    设置访问传递参数  params = {"username"}
    @RequestMapping(value = "hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "index";
    }

//   通过ModelAndView的方式访问index界面
    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("success");
//   向模型中添加数据  注意：在jsp页面取数据时需要设置是否忽略表达式
        modelAndView.addObject("username","tom");
        System.out.println("this is ModelAndView ");
        return modelAndView;
    }

//    通过model的方式设置模型数据
    @RequestMapping("test1")
    public String test1(Model model){
        model.addAttribute("username","lucy");
        return "log";
    }
//    返回字符串 需要加@resposebody注解
    @RequestMapping("test2")
    @ResponseBody
    public String test2(){
        return "this is test2";
    }

//    返回json格式的数据对象：需要配置jackson全家桶（jackson-core jackson-annotations jackson-databind）三个依赖包
    @RequestMapping("test3")
    @ResponseBody
    public User test3(){
        User user=new User("jery",20,"1","aa");
        return user;
    }
}