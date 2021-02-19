package com.gt.conductor.controller;

import com.gt.conductor.dto.RideRecords;
import com.gt.conductor.feign.EmpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by asus on 2021/2/18.
 */
@Controller
public class EmpController {

    @Autowired(required = false)
    private EmpClient empClient;

    @RequestMapping(value = "/getRecords",method = RequestMethod.GET)
    @ResponseBody
    public List<RideRecords> getAllRide(Integer page,Integer rows,Integer conductor){
        return empClient.getAllRideRecords(page,rows,conductor);
    }
}
