package com.tekion.GameCrick.controller;

import com.tekion.GameCrick.Repository.TeamRepository;
import com.tekion.GameCrick.Service.TeamService;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public void addTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id){
        return  teamService.getTeam(id);
    }

}
