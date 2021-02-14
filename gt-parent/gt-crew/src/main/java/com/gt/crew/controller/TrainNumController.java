package com.gt.crew.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.crew.dto.SendClass;
import com.gt.crew.dto.TrainNum;
import com.gt.crew.service.TrainNumService;
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
 * 车次管理表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-13
 */
@Controller
@RequestMapping("/trainNum")
public class TrainNumController {

    @Autowired
    private TrainNumService trainNumService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllTrainNum(Integer page,Integer rows,TrainNum trainNum){
        QueryWrapper<TrainNum> trainNumQueryWrapper = new QueryWrapper<>();
        //查询条件
        if (null!=trainNum.getRailways()) trainNumQueryWrapper.eq("railways",trainNum.getRailways());

        if (null!=trainNum.getKyd()) trainNumQueryWrapper.eq("kyd",trainNum.getKyd());

        if (null!=trainNum.getFiliale()) trainNumQueryWrapper.eq("filiale",trainNum.getFiliale());

        if (null!=trainNum.getTrainNum()) trainNumQueryWrapper.like("train_num",trainNum.getTrainNum()+"%");

        if (null!=trainNum.getTrainType()) trainNumQueryWrapper.eq("train_type",trainNum.getTrainType());

        if (null!=trainNum.getStartingAds()) trainNumQueryWrapper.like("starting_ads",trainNum.getStartingAds()+"%");

        if (null!=trainNum.getEndingAds()) trainNumQueryWrapper.like("ending_ads",trainNum.getEndingAds()+"%");

        List<TrainNum> list = trainNumService.list(trainNumQueryWrapper);
        //分页
        PageHelper.startPage(page,rows);
        PageInfo<TrainNum> pageInfo = new PageInfo<TrainNum>(list);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",pageInfo.getTotal());
        pageMap.put("rows",pageInfo.getList());
        return pageMap;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateTrainNum(@PathVariable("opType") Integer opType, TrainNum trainNum){

        UpdateWrapper<TrainNum> trainNumUpdateWrapper = new UpdateWrapper<>();
        trainNumUpdateWrapper.eq("train_id",trainNum.getTrainId());
        String alert = "";
        boolean rs = false;

        if (opType == 1){
            rs = trainNumService.save(trainNum);
            alert = "新增车次";
        }

        if (opType == 2){
            rs = trainNumService.update(trainNum,trainNumUpdateWrapper);
            alert = "修改";
        }

        if (opType == 3){
            rs = trainNumService.remove(trainNumUpdateWrapper);
            alert = "删除";
        }

        if (rs){
            return ResponseEntity.status(200).body(alert+"成功！");
        }
        return ResponseEntity.status(400).body("系统错误！");
    }
}

