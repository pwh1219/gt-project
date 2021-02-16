package com.gt.gtadmin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.gtadmin.bean.RoleAuthority;
import com.gt.gtadmin.mapper.RoleAuthorityMapper;
import com.gt.gtadmin.service.RoleAuthorityService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关联角色和权限的信息 服务实现类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Service
public class RoleAuthorityServiceImpl extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements RoleAuthorityService {

}
