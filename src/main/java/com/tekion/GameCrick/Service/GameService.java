package com.tekion.GameCrick.Service;
import com.tekion.GameCrick.Repository.ESMatchRepository;
import com.tekion.GameCrick.Repository.MatchRepository;
import com.tekion.GameCrick.Repository.PlayerRepository;
import com.tekion.GameCrick.Repository.TeamRepository;
import com.tekion.GameCrick.model.ESMatch;
import com.tekion.GameCrick.model.Match;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class GameService {
    @Autowired
    private ESMatchRepository eSMatchRepository;
    @Autowired
    private InningService inningService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private ScoreboardService scoreboardService;
    @Autowired
    private MatchRepository matchRepository;
    private static final int INT_MAX = (int)1e9;

    public void prepMatch(Match match){
        int numOvers = match.getNoOfOvers();
        Team teamA = teamService.getTeam(match.getFirstTeamId());
        Team teamB = teamService.getTeam(match.getSecondTeamId());
        teamB.setTotalWickets(0);
        teamB.setTotalScore(0);
        teamB.setTotalBalls(0);
        teamA.setTotalWickets(0);
        teamA.setTotalScore(0);
        teamA.setTotalBalls(0);
        playerService.setPlayers(teamA,teamB);

        play(teamA, teamB, numOvers);

        String winnerTeam = scoreboardService.printScore(teamA, teamB, numOvers);

        Match matchDB = Match.builder()
                           .firstTeamId(teamA.getId())
                           .secondTeamId(teamB.getId())
                           .noOfOvers(numOvers)
                           .team1Total(teamA.getTotalScore())
                           .team2Total(teamB.getTotalScore())
                             .winner(winnerTeam)
                           .build();

        ESMatch matchDBES = ESMatch.builder()
                                   .firstTeamId(teamA.getId())
                                   .secondTeamId(teamB.getId())
                                   .noOfOvers(numOvers)
                                   .team1Total(teamA.getTotalScore())
                                   .team2Total(teamB.getTotalScore())
                                   .winner(winnerTeam)
                                   .build();

        matchRepository.save(matchDB);
        eSMatchRepository.save(matchDBES);

    }

    public void play(Team teamA, Team teamB, int numOvers){
        inningService.playInning(teamA, numOvers, INT_MAX);
        inningService.playInning(teamB, numOvers, teamA.getTotalScore()+1);
    }

    public Match getMatch(Long id){
        return matchRepository.findById(id).orElse(null);
    }
}
