package com.gt.gtadmin.service.impl;

import com.gt.gtadmin.bean.SysParam;
import com.gt.gtadmin.mapper.SysParamMapper;
import com.gt.gtadmin.service.SysParamService;
import com.gt.gtcommon.util.RedisKey;
import com.gt.gtcommon.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zz
 * @Date 2021/2/10 15:09
 */
@Service
public class SysParamServiceImpl implements SysParamService {
    @Autowired
    private SysParamMapper sysParamMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisKey redisKey;

    @Override
    public void loadSysParam() {
        // 用来存放所有字段的数据
        Map<String, Object> sysParamMap = new HashMap<>();
        // 用来存放各个字段的数据
        List<SysParam> sysParams = sysParamMapper.selectAll();
        Map<String, String> filedMap = null;
        for (SysParam sysParam : sysParams) {
            if ("2".equals(sysParam.getSysParamType())) {
                // 暂时不处理
            } else {
                if (null == (sysParamMap.get(sysParam.getSysParamField()))) {
                    // 该字段从来都没有存放到系统的map中
                    filedMap = new LinkedHashMap<>();
                    filedMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
                    sysParamMap.put(sysParam.getSysParamField(), filedMap);
                } else {
                    filedMap = (Map<String, String>) sysParamMap.get(sysParam.getSysParamField());
                    filedMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
                }
            }
        }
    }
}
