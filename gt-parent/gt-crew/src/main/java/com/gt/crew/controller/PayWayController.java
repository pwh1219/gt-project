package com.gt.crew.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.crew.dto.PayWay;
import com.gt.crew.service.PayWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * 交路管理表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-13
 */
@Controller
@RequestMapping("/payWay")
public class PayWayController {

    @Autowired
    private PayWayService payWayService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllPayWay(Integer page, Integer rows, PayWay payWay){
        QueryWrapper<PayWay> wayWrapper = new QueryWrapper<>();
        //查询条件
        if (null!=payWay.getRailways()) wayWrapper.eq("railways",payWay.getRailways());

        if (null!=payWay.getKyd()) wayWrapper.eq("kyd",payWay.getKyd());

        if (null!=payWay.getFiliale()) wayWrapper.eq("filiale",payWay.getFiliale());

        if (null!=payWay.getPayName()) wayWrapper.like("pay_name",payWay.getPayName()+"%");

        if (null!=payWay.getTrainType()) wayWrapper.eq("train_type",payWay.getTrainType());

        if (null!=payWay.getTrainNum()) wayWrapper.like("train_num",payWay.getTrainNum());

        List<PayWay> list = payWayService.list(wayWrapper);
        //分页
        PageHelper.startPage(page,rows);
        PageInfo<PayWay> pageInfo = new PageInfo<PayWay>(list);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",pageInfo.getTotal());
        pageMap.put("rows",pageInfo.getList());
        return pageMap;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updatePayWay(@PathVariable("opType") Integer opType, PayWay payWay){

        UpdateWrapper<PayWay> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pay_id",payWay.getPayId());
        boolean rs = false;
        String alert = "";

        if (opType == 1){
          rs = payWayService.save(payWay);
          alert = "新增";
        }

        if (opType == 2){
          rs = payWayService.update(payWay,updateWrapper);
          alert = "修改";
        }

        if (opType == 3){
          rs = payWayService.remove(updateWrapper);
          alert = "删除";
        }

        if (rs) {
            return ResponseEntity.status(200).body("交路"+alert+"成功！");
        }
        return ResponseEntity.status(400).body("系统错误！操作失败！");
    }
}

