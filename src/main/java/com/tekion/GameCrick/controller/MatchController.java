package com.tekion.GameCrick.controller;

import com.tekion.GameCrick.Service.GameService;
import com.tekion.GameCrick.Service.ScoreService;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.model.Team;
import com.tekion.GameCrick.Service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private GameService gameService;
    @Autowired
    private ScoreboardService scoreboardService;

    @PostMapping("/")
    public void startMatch(){
        int numOvers;
        Team teamA = new Team();
        teamA.setTeamName("India");
        Team teamB = new Team();
        Scanner sc = new Scanner(System.in);
        teamB.setTeamName("India2");
        numOvers = 5;
        for(int i=0;i<11;i++){
            Player pi = new Player();
            pi.setPlayerName(teamA.getTeamName() + (i + 1));
            teamA.getTeamMembers().add(pi);
        }
        for(int i=0;i<11;i++){
            Player pi = new Player();
            pi.setPlayerName(teamB.getTeamName() + (i + 1));
            teamB.getTeamMembers().add(pi);
        }
        gameService.play(teamA, teamB, numOvers);
        scoreboardService.printScore(teamA, teamB, numOvers);
    }
}
