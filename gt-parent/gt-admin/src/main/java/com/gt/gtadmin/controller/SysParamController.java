package com.gt.gtadmin.controller;


import com.gt.gtadmin.service.SysParamService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * @Author Zz
 * @Date 2020/12/8 15:26
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/sysParam")
public class SysParamController {

    @Resource
    ServletContext application;

    @Resource
    private SysParamService sysParamService;

    /**
     * 表示在构造方法后面执行
     */
    @PostConstruct
    public void loadSysParam() {
        sysParamService.loadSysParam();
    }
}

