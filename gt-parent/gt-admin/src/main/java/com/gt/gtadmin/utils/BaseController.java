package com.gt.gtadmin.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@Controller
@RequestMapping("/base")
public class BaseController {
    @Resource
    ServletContext applicationContext;

    /**
     * 定义一个通用的页面跳转方法
     *
     * @return
     */
    @RequestMapping(value = "goURL/{folder}/{file}",method = RequestMethod.GET)
    public String goUrl(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return folder + "/" + file;
    }
}