package com.gt.employee.service.impl;

import com.gt.employee.dto.Team;
import com.gt.employee.mapper.TeamMapper;
import com.gt.employee.service.TeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班组表 服务实现类
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {

}
