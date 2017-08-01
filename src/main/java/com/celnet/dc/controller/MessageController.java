package com.celnet.dc.controller;

import javax.validation.Valid;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Controller：
//1：spring的控制层。
//2：spring的注解之一放在类名之前
//3:spring配置文件中如果配置了扫描包路径，自动检测该注释的类并注入。
//4：spring控制层可以接收请求，并且返回响应。
@Controller  
//用户请求路径是http://localhost:8080/项目名/类的@RequestMapping的value值/方法的@RequestMapping的value值。
@RequestMapping("/")  
public class MessageController {  
//    private final MessageRepository messageRepository;  
////        @PathVariable：rest访问方式获取参数传递
////        ModelAndView：一次性返回model和view2个对象,有7个构造函数，用来设定返回对象和视图，也可以用set方法设置。
////        @ModelAttribute：获取页面传递参数。也可以这样用
//    @Autowired  //依赖注入。
//    public MessageController(MessageRepository messageRepository) {  
//        this.messageRepository = messageRepository;  
//    }  
//  
//
//    @RequestMapping  
//    public ModelAndView list() {  
//        Iterable<Message> messages = this.messageRepository.findAll();  
//        return new ModelAndView("messages/list", "messages", messages);  
//    }  
//  
//    //@PathVariable rest访问方式获取参数传递
//    @RequestMapping("{id}")  
//    public ModelAndView view(@PathVariable("id") Message message) {  
//        return new ModelAndView("messages/view", "message", message);  
//    }  
//  
//    @RequestMapping(params = "form", method = RequestMethod.GET)  
//    public String createForm(@ModelAttribute Message message) {  
//        return "messages/form";  
//    }  
//  
//    //@Valid：对实体类的一个验证。验证符合jpa的标准。要和BindingResult result配合使用，如果验证不通过的话，result.hasErrors()，跳转 。
//    @RequestMapping(method = RequestMethod.POST)  
//    public ModelAndView create(@Valid Message message, BindingResult result,  
//            RedirectAttributes redirect) {  
//        if (result.hasErrors()) {  
//            return new ModelAndView("messages/form", "formErrors", result.getAllErrors());  
//        }  
//        message = this.messageRepository.save(message);  
//        redirect.addFlashAttribute("globalMessage", "Successfully created a new message");  
//        return new ModelAndView("redirect:/{message.id}", "message.id", message.getID());  
//    }  
//  
//    @RequestMapping("foo")  
//    public String foo() {  
//        throw new RuntimeException("Expected exception in controller");  
//    }  
  
    
}  