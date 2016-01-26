package com.younghoe.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * <p><a href="http://www.captaindebug.com/2011/11/using-spring-mvcs-modelattribute.html#.VqbN0lOLSRs">
 * Using Spring MVC’s @ModelAttribute Annotation</a>를 그대로 따라해봄. 단 View는 FreeMarker로 구현</p>
 * <p>오류 메시지 출력에 대한 부분은 <a href="http://www.mkyong.com/spring-mvc/spring-3-mvc-and-jsr303-valid-example/">
 * Spring 3 MVC and JSR303 @Valid example</a> 참조</p>
 * Created by tony on 2016. 1. 26..
 */
@Controller
public class AddUserController {

    @RequestMapping(path = "/adduser", method = RequestMethod.GET)
    public String createForm(@ModelAttribute("user") User user, Model model){
        model.addAttribute("user", user);
        return "adduser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") @Valid  User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        if(result.hasErrors())
            return "adduser";
        else
            return "welcome";
    }

}
