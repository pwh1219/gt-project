package com.gt.gtadmin.controller;


import com.gt.gtadmin.bean.UserManage;
import com.gt.gtadmin.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 用户管理表 前端控制器
 * </p>
 *
 * @Author Zz
 * @Date 2021/2/11 9:58
 */
@Controller
@RequestMapping("/user")
public class UserManageController {

    @Resource
    private UserManageService userManageService;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    /**
     * 登录
     *
     * @param userManage 传过来一个账号密码
     * @return 根据查询结果返回页面
     */
    @PostMapping(value = "/login")
    public String login(UserManage userManage) {
        UserManage login = userManageService.login(userManage);
        String goUrl = "";
        if (login != null) {
            goUrl = "main";
            session.setAttribute("login", login);
            request.getSession().setAttribute("login", login);
        } else {
            goUrl = "login";
            session.setAttribute("loginMsg", "账号或密码不正确!!!");
        }
        return goUrl;
    }

    /**
     * 修改密码
     *
     * @param userManage 传过来需要修改的账号和密码
     * @return 返回修改结果
     */
    @PostMapping("/updatePwd")
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> updatePassword(UserManage userManage) {
        Map<String, Integer> map = userManageService.updatePassword(userManage);
        return ResponseEntity.ok(map);
    }
}

