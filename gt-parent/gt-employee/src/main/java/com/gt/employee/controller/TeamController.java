package com.gt.employee.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gt.employee.dto.Team;
import com.gt.employee.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 班组表 前端控制器
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllTeam(Integer page, Integer rows,Team team){
        QueryWrapper<Team> teamQueryWrapper = new QueryWrapper<>();
        if (null!=team.getRailways()) teamQueryWrapper.eq("railways",team.getRailways());

        if (null!=team.getKyd()) teamQueryWrapper.eq("kyd",team.getKyd());

        if (null!=team.getFiliale()) teamQueryWrapper.eq("filiale",team.getFiliale());

        if (null!=team.getTeamNum()) teamQueryWrapper.like("team_num",team.getTeamNum()+"%");

        if (null!=team.getTeamType()) teamQueryWrapper.eq("team_type",team.getTeamType());

        if (null!=team.getTeamLeader()) teamQueryWrapper.like("team_leader",team.getTeamLeader()+"%");

        if (null!=team.getTrainType()) teamQueryWrapper.eq("train_type",team.getTrainType());

        teamQueryWrapper.eq("is_del","0");
        List<Team> list = teamService.list(teamQueryWrapper);

        PageHelper.startPage(page,rows);
        PageInfo<Team> pageInfo = new PageInfo<>(list);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("total",pageInfo.getTotal());
        pageMap.put("rows",pageInfo.getList());
        return pageMap;
    }

    @RequestMapping(value = "/{opType}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateTeam(@PathVariable("opType") Integer opType,Team team){
        UpdateWrapper<Team> teamUpdateWrapper = new UpdateWrapper<>();
        teamUpdateWrapper.eq("team_id",team.getTeamId());
        String alert = "";
        boolean rs = false;

        if (opType == 1){
            rs = teamService.save(team);
            alert = "添加";
        }

        if (opType == 2){
            rs = teamService.update(team,teamUpdateWrapper);
            alert = "修改";
        }

        if (opType == 3){
            team.setIsDel("1");
            rs = teamService.update(team,teamUpdateWrapper);
            alert = "删除";
        }

        if (rs) return ResponseEntity.status(200).body(alert+"成功！");
        return ResponseEntity.status(400).body("系统错误！");
    }
}

