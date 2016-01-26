package com.younghoe.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>예제 HTML과 JS 출처는 <a href="https://www.datatables.net/examples/basic_init/zero_configuration.html">
 * Zero configuration Example</a></p>
 * Created by tony on 2016. 1. 26..
 */
@Controller
public class DataTablesController {

    @RequestMapping("/datatables")
    public String datatables(){
        return "datatables";
    }
}
