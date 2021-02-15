package com.gt.employee.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.employee.dto.Trainman;
import com.gt.employee.service.TrainmanService;
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
 * 列车员管理表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-15
 */
@Controller
@RequestMapping("/trainman")
public class TrainmanController {

    @Autowired
    private TrainmanService trainmanService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllTrainMan(Integer page,Integer rows,Trainman trainman){
        QueryWrapper<Trainman> trainmanQueryWrapper = new QueryWrapper<>();
        if (null!=trainman.getRailways()) trainmanQueryWrapper.eq("railways",trainman.getRailways());

        if (null!=trainman.getKyd()) trainmanQueryWrapper.eq("kyd",trainman.getKyd());

        if (null!=trainman.getFiliale()) trainmanQueryWrapper.eq("filiale",trainman.getFiliale());

        if (null!=trainman.getStatus()){
            trainmanQueryWrapper.eq("status",trainman.getStatus());
        }else {
            trainmanQueryWrapper.eq("status","0");
        }

        if (null!=trainman.getManName()) trainmanQueryWrapper.like("man_name",trainman.getManName()+"%");

        if (null!=trainman.getManAccount()) trainmanQueryWrapper.like("man_account",trainman.getManAccount()+"%");

        if (null!=trainman.getIdCard()) trainmanQueryWrapper.like("id_card",trainman.getIdCard()+"%");

        if (null!=trainman.getPhone()) trainmanQueryWrapper.like("phone",trainman.getPhone()+"%");
        List<Trainman> list = trainmanService.list(trainmanQueryWrapper);

        PageHelper.startPage(page,rows);
        PageInfo<Trainman> pageInfo = new PageInfo<>(list);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",pageInfo.getTotal());
        pageMap.put("rows",pageInfo.getList());
        return pageMap;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateTrainMan(@PathVariable("opType") Integer opType, Trainman trainman){
        UpdateWrapper<Trainman> trainmanUpdateWrapper = new UpdateWrapper<>();
        trainmanUpdateWrapper.eq("man_id",trainman.getManId());
        String alert = "";
        boolean rs = false;

        if (opType == 1){
            trainman.setManPassword("111111");
            rs = trainmanService.save(trainman);
            alert = "添加";
        }

        if (opType == 2){
            rs = trainmanService.update(trainman,trainmanUpdateWrapper);
            alert = "修改";
        }

        if (rs) return ResponseEntity.status(200).body(alert+"成功！");
        return ResponseEntity.status(400).body("系统错误！");
    }
}

