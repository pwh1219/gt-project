package com.gt.gtadmin.service.impl;


import com.gt.gtadmin.entity.SysUser;
import com.gt.gtadmin.mapper.SysUserMapper;
import com.gt.gtadmin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    //下边可能会报错，等控制器加了@EnableAutoConfiguration就不会了
    @Autowired
    private SysUserMapper sysUserMapper;

    //如果用户不存在返回
    @Override
    public Map<String, Object> login(SysUser sysUser) {
        SysUser returnUser = sysUserMapper.login(sysUser);
        if (returnUser == null) {
            return null;
        }
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("sysUser", returnUser);
        return returnMap;
    }

    @Override
    public void insert(SysUser sysUser) throws Exception {
        sysUserMapper.insert(sysUser);
        //第二次保存，主键冲突，应该不成功，观察数据库插入了多少条数据？
        sysUserMapper.insert(sysUser);
    }

}
