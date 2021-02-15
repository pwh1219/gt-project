package com.gt.employee.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.employee.dto.RideRecords;
import com.gt.employee.service.RideRecordsService;
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
 * 出乘记录表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
@Controller
@RequestMapping("/rideRecords")
public class RideRecordsController {

    @Autowired
    private RideRecordsService rideRecordsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllRecords(Integer page, Integer rows, Integer manId){
        QueryWrapper<RideRecords> recordsQueryWrapper = new QueryWrapper<>();
        recordsQueryWrapper.eq("conductor",manId);

        List<RideRecords> list = rideRecordsService.list(recordsQueryWrapper);
        PageHelper.startPage(page,rows);
        PageInfo<RideRecords> pageInfo = new PageInfo<>(list);
        Map<String,Object> pageMap = new HashMap<>();
        return null;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateRecords(@PathVariable("opType") Integer opType, RideRecords rideRecords){
        UpdateWrapper<RideRecords> recordsUpdateWrapper = new UpdateWrapper<>();
        recordsUpdateWrapper.eq("conductor",rideRecords.getConductor());
        boolean rs = false;
        String alert = "";

        if (opType == 1){
            rideRecords.setRideTime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            rs = rideRecordsService.save(rideRecords);
            alert = "出乘";
        }

        if (opType == 2){
            rideRecords.setByTime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            rs = rideRecordsService.update(rideRecords,recordsUpdateWrapper);
            alert = "下乘";
        }

        if (rs) return ResponseEntity.status(200).body(alert+"成功！");
        return ResponseEntity.status(400).body("系统错误！");
    }
}

