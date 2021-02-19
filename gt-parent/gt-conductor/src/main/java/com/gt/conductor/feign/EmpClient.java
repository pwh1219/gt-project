package com.gt.conductor.feign;

import com.gt.conductor.dto.RideRecords;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by asus on 2021/2/18.
 */
@FeignClient(name = "emp-client",url = "http://127.0.0.1:8090/")
public interface EmpClient {

    @RequestMapping(value = "rideRecords",method = RequestMethod.GET)
    public List<RideRecords> getAllRideRecords(@RequestParam("page") Integer page,
                                               @RequestParam("rows") Integer rows,
                                               @RequestParam("conductor") Integer conductor);
}
