package com.gt.employee.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.employee.dto.Duty;
import com.gt.employee.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 职务管理表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
@Controller
@RequestMapping("/duty")
public class DutyController {

    @Autowired
    private DutyService dutyService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllDuty(Integer page, Integer rows, Duty duty){
        QueryWrapper<Duty> dutyQueryWrapper = new QueryWrapper<>();
        if (null!=duty.getIsAble()){
            dutyQueryWrapper.eq("is_able",duty.getIsAble());
        }else {
            dutyQueryWrapper.eq("is_able","1");
        }

        List<Duty> list = dutyService.list(dutyQueryWrapper);

        PageHelper.startPage(page,rows);
        PageInfo<Duty> pageInfo = new PageInfo<>(list);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",pageInfo.getTotal());
        pageMap.put("rows",pageInfo.getList());
        return pageMap;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateDuty(@PathVariable("opType") Integer opType, Duty duty){
        UpdateWrapper<Duty> dutyUpdateWrapper = new UpdateWrapper<>();
        dutyUpdateWrapper.eq("duty_tag",duty.getDutyTag());
        String alert = "";
        boolean rs = false;

        if (opType == 1){
            duty.setDutyCtime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            duty.setDutyUtime(duty.getDutyCtime());
            rs = dutyService.save(duty);
            alert = "添加";
        }

        if (opType == 2){
            duty.setDutyUtime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            rs = dutyService.update(duty,dutyUpdateWrapper);
            alert = "修改";
        }

        if (rs){
            return ResponseEntity.status(200).body(alert+"成功！");
        }
        return ResponseEntity.status(400).body("系统错误！");
    }
}

