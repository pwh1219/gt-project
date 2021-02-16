package com.gt.gtadmin.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zz
 * @Date 2021/2/11 12:54
 */
public class ReturnMap {
    public static Map<String, Integer> resultMap(Integer integer) {
        Map<String, Integer> map = new HashMap<>();
        if (integer == 1) {
            map.put("msg", integer);
        } else {
            map.put("msg", integer);
        }
        return map;
    }
}
