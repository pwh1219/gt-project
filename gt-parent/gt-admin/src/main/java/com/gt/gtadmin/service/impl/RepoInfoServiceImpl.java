package com.gt.gtadmin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.gtadmin.bean.RepoInfo;
import com.gt.gtadmin.mapper.RepoInfoMapper;
import com.gt.gtadmin.service.RepoInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库信息管理，用来存放各个仓库的信息 服务实现类
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Service
public class RepoInfoServiceImpl extends ServiceImpl<RepoInfoMapper, RepoInfo> implements RepoInfoService {

}
