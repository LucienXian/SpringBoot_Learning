package com.example.demo.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("thymeleafTemplateHelloController")
public class HelloController {

    @RequestMapping("/template/")
    public String index(ModelMap map) {
        map.addAttribute("host", "https://github.com/");
        return "index";
    }
}
