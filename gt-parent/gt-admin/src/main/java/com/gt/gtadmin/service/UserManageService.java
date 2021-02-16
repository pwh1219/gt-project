package com.gt.gtadmin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gt.gtadmin.bean.UserManage;

import java.util.Map;

/**
 * <p>
 * 用户管理表 服务类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
public interface UserManageService extends IService<UserManage> {
    public UserManage login(UserManage userManage);
    public Map<String, Integer> updatePassword(UserManage userManage);
}
