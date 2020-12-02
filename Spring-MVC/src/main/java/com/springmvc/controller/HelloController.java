package com.springmvc.controller;


import com.springmvc.admin.User;
import com.springmvc.admin.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
//    获得请求参数为属性时
    @RequestMapping("test4")
    @ResponseBody
    public void test4(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }
//    获得请求参数为对象时
    @RequestMapping("test5")
    @ResponseBody
    public void test5(User user){
        System.out.println(user);
    }
//    获得请求参数为数组对象时
    @RequestMapping("test6")
    @ResponseBody
    public void test5(String[] sts){
        System.out.println(Arrays.asList(sts));
    }
//    通过页面表单提交集合的方式获得请求参数
    @RequestMapping("test7")
    @ResponseBody
    public void test7(UserList users){
        System.out.println(users);
    }

//    通过ajax异步提交数据
    @RequestMapping("test8")
    @ResponseBody
    public void test8(@RequestBody List<User> userList){
        System.out.println(userList);
    }
//    单个文件上传的代码实现
    @RequestMapping("test9")
    @ResponseBody
    public void test9(String username, MultipartFile upload) throws IOException {
        System.out.println(username);
        System.out.println(upload);
        String filename = upload.getOriginalFilename();
        upload.transferTo(new File("d:\\upload\\"+filename));
    }
}