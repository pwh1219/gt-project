package com.gt.gtadmin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gt.gtadmin.bean.SysParam;
import com.gt.gtadmin.mapper.SysParamMapper;
import com.gt.gtadmin.service.SysParamService;
import com.gt.gtcommon.util.RedisKey;
import com.gt.gtcommon.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统参数表，用来存放放到内存中使用的常用参数 服务实现类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Service
public class SysParamServiceImpl extends ServiceImpl<SysParamMapper, SysParam> implements SysParamService {

    @Resource
    private SysParamMapper sysParamMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisKey redisKey;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void loadSysParam() {
        try {
            // 先删除
            redisUtils.delete(redisKey.SYSTEM_PARAM);
            // 用来存放所有字段的数据
            Map<String, Object> sysParamMap = new HashMap<>();
            // 用来存放各个字段的数据
            List<SysParam> sysParams = sysParamMapper.selectList(null);
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

            String sysMap = objectMapper.writeValueAsString(sysParamMap);
            redisUtils.set(redisKey.SYSTEM_PARAM, sysMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
