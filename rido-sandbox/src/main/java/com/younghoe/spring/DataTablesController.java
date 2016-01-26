package com.younghoe.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tony on 2016. 1. 26..
 */
@Controller
public class DataTablesController {

    @RequestMapping("/datatables")
    public String datatables(){
        return "datatables";
    }
}
