package com.younghoe.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * <p>
 *     Command 객체 바인딩 하는 예제. Spring 3 MVC와 함께 JSR 303 @Valid를 사용. 메시지 처리는 resource 디렉토리 아래의
 *     messages.properties 파일에 지정.
 * </p>
 *
 * @author Younghoe Ahn
 * @see <p><a href="http://www.captaindebug.com/2011/11/using-spring-mvcs-modelattribute.html#.VqbN0lOLSRs">
 * Using Spring MVC’s @ModelAttribute Annotation</a>
 * @see <a href="http://www.mkyong.com/spring-mvc/spring-3-mvc-and-jsr303-valid-example/">
 * Spring 3 MVC and JSR303 @Valid example</a>
 *
 */
@SpringBootApplication
@Controller
public class WebApplication {

    public static void main(String... args){
        SpringApplication.run(WebApplication.class, args);
    }


    private final String VIEWS = "form/";

    @RequestMapping(path = "/adduser", method = RequestMethod.GET)
    public String createForm(@ModelAttribute("user") User user, Model model){
        model.addAttribute("user", user);
        return VIEWS + "adduser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        if(result.hasErrors())
            return VIEWS + "adduser";
        else
            return VIEWS + "welcome";
    }
}
