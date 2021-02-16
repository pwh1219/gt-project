package com.gt.gtadmin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.gtadmin.bean.UserManage;
import com.gt.gtadmin.mapper.UserManageMapper;
import com.gt.gtadmin.service.UserManageService;
import com.gt.gtadmin.utils.ReturnMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 用户管理表 服务实现类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Service
public class UserManageServiceImpl extends ServiceImpl<UserManageMapper, UserManage> implements UserManageService {

    @Resource
    private UserManageMapper userManageMapper;

    @Override
    public UserManage login(UserManage userManage) {
        QueryWrapper<UserManage> userWrapper = new QueryWrapper<>();
        userWrapper
                .eq("user_count", userManage.getUserCount())
                .eq("password", userManage.getPassword());
        return userManageMapper.selectOne(userWrapper);
    }


    @Override
    public Map<String, Integer> updatePassword(UserManage userManage) {
        int i = userManageMapper.updateById(userManage);
        return ReturnMap.resultMap(i);
    }
}
