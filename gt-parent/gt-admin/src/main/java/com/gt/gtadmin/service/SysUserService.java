package com.gt.gtadmin.service;


import com.gt.gtadmin.entity.SysUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


public interface SysUserService {

    public Map<String, Object> login(SysUser sysUser);

    //添加保存用户的方法
    @Transactional
    public void insert(SysUser sysUser) throws Exception;

}
