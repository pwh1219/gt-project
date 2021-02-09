package com.gt.gtadmin.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhh on 2019-03-31.
 */
@Controller
@RequestMapping("home")
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping("/hello")
    public ModelAndView toIndex() {
        ModelMap model = new ModelMap();
        model.addAttribute("name", "SpringBoot");
        return new ModelAndView("index", model);
    }
}
