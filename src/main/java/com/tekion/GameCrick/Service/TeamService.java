package com.tekion.GameCrick.Service;

import com.tekion.GameCrick.Repository.ESTeamRepository;
import com.tekion.GameCrick.Repository.TeamRepository;
import com.tekion.GameCrick.model.ESTeam;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ESTeamRepository esTeamRepository;

    public void addTeam(Team team){
        ESTeam temp = ESTeam.builder()
                .id(team.getId())
                .teamMembers(team.getTeamMembers())
                .name(team.getName())
                .totalScore(team.getTotalScore())
                .totalBalls(team.getTotalBalls())
                .totalWickets(team.getTotalWickets())
                .build();
        teamRepository.save(team);
        esTeamRepository.save(temp);
    }


    public Team getTeam(Long id){
        return teamRepository.findById(id).orElse(null);
    }
}
