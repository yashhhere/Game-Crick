package com.tekion.GameCrick.Service;

import com.tekion.GameCrick.Repository.TeamRepository;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public Team getTeam(Long id){
        return teamRepository.findById(id).orElse(null);
    }
}
