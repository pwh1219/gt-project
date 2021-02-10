package com.gt.gtadmin.controller;


import com.gt.gtadmin.entity.SysUser;
import com.gt.gtadmin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * /@EnableAutoConfiguration 启用自动装配的注解
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class SysUserAction {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login")
    //@ResponseBody
    public Object login() {
        SysUser sysUser = new SysUser();
        System.out.println("---action.sysUser:" + sysUser);
        sysUser.setUsercode("hc001");
        sysUser.setPassword("123456");
        Map<String, Object> map = sysUserService.login(sysUser);
        if (null == map) {
            //return "forward:/login.jsp";
            return "no person";
        }
        return map.get("sysUser");
    }

    @RequestMapping(value = "insert")
    //@ResponseBody
    public Object insert() {
        SysUser sysUser = new SysUser();
        sysUser.setId("u0111");
        sysUser.setUsercode("hc0111");
        sysUser.setUsername("钟测试111");
        sysUser.setPassword("123456");
        Map<String, Object> map = new HashMap<>();
        try {
            sysUserService.insert(sysUser);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        return map;
    }

}
