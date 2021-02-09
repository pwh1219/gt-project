package com.gt.gtadmin.mapper;

/**
 * @Author Zz
 * @Date 2021/1/28 16:11
 */

import com.gt.gtadmin.entity.SysUser;

//不使用Mapper注解，可以在启动类中加入@MapperScan("com.hx.shangji.manager.mapper")
//@Mapper
public interface SysUserMapper {

    //登陆,也可以使用如下注解方式编写sql,需要把
    // application.properties中的mybatis.mapper-locations=classpath*:mapper/*.xml去掉
    //@Select("select * from sys_user where usercode=#{usercode} and password=#{password}")
    public SysUser login(SysUser sysUser);

    public int insert(SysUser sysUser);

}

