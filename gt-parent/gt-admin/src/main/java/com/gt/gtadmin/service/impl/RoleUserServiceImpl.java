package com.gt.gtadmin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.gtadmin.bean.RoleUser;
import com.gt.gtadmin.mapper.RoleUserMapper;
import com.gt.gtadmin.service.RoleUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关联角色和用户 服务实现类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

}
