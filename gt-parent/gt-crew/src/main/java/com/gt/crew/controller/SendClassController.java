package com.gt.crew.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.crew.dto.PayWay;
import com.gt.crew.dto.SendClass;
import com.gt.crew.service.SendClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 派班管理表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-13
 */
@Controller
@RequestMapping("/sendClass")
public class SendClassController {

    @Autowired
    private SendClassService sendClassService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> getAllSendClass(Integer page,Integer rows,SendClass sendClass){
        QueryWrapper<SendClass> sendClassQueryWrapper = new QueryWrapper<>();
        //查询条件
        if (null!=sendClass.getRailways()) sendClassQueryWrapper.eq("railways",sendClass.getRailways());

        if (null!=sendClass.getKyd()) sendClassQueryWrapper.eq("kyd",sendClass.getKyd());

        if (null!=sendClass.getFiliale()) sendClassQueryWrapper.eq("filiale",sendClass.getFiliale());

        if (null!=sendClass.getPayName()) sendClassQueryWrapper.like("pay_name",sendClass.getPayName()+"%");

        if (null!=sendClass.getTeamNum()) sendClassQueryWrapper.like("team_num",sendClass.getTeamNum()+"%");

        List<SendClass> list = sendClassService.list(sendClassQueryWrapper);
        //分页
        PageHelper.startPage(page,rows);
        PageInfo<SendClass> pageInfo = new PageInfo<SendClass>(list);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",pageInfo.getTotal());
        pageMap.put("rows",pageInfo.getList());
        return pageMap;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateSendClass(@PathVariable("opType") Integer opType, SendClass sendClass){

        UpdateWrapper<SendClass> sendClassUpdateWrapper = new UpdateWrapper<>();
        sendClassUpdateWrapper.eq("class_id",sendClass.getClassId());
        String alert = "";
        boolean rs = false;

        if (opType == 2){
            rs = sendClassService.update(sendClass,sendClassUpdateWrapper);
            alert = "启动热备";
        }

        if (opType == 3){
            rs = sendClassService.remove(sendClassUpdateWrapper);
            alert = "撤回";
        }

        if (rs){
            return ResponseEntity.status(200).body(alert+"成功！");
        }
        return ResponseEntity.status(400).body("系统错误！");
    }

}

