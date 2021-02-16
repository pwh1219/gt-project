package com.gt.gtadmin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gt.gtadmin.bean.SysParam;

/**
 * <p>
 * 系统参数表，用来存放放到内存中使用的常用参数 服务类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
public interface SysParamService extends IService<SysParam> {
    public void loadSysParam();
}
