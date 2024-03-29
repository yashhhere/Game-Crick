package com.tekion.GameCrick.Service;
import com.tekion.GameCrick.Repository.ESTeamRepository;
import com.tekion.GameCrick.Repository.TeamRepository;
import com.tekion.GameCrick.model.ESTeam;
import com.tekion.GameCrick.model.Team;
import com.tekion.GameCrick.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InningService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ESTeamRepository eSTeamRepository;

    public void playInning(Team teamA, int numOvers, int target) {
        ArrayList<Player> teamAPlayers = teamA.getTeamMembers();
        int index = 2;
        Player striker = teamAPlayers.get(0);
        Player runner = teamAPlayers.get(1);
        outer:
        for (int i = 0; i < numOvers; i++) {
            for (int bowl = 0; bowl < 6; bowl++) {
                teamA.setTotalBalls(teamA.getTotalBalls() + 1);
                int runs;
                if (index > 6) {
                    runs = striker.getRunABall("bowler");
                } else {
                    runs = striker.getRunABall("batsman");
                }
                if (runs == 5 || runs >= 7 && teamA.getTotalScore() < target) {
                    striker.setBallsFaced(striker.getBallsFaced() + 1);
                    striker.setOut(true);
                    teamA.setTotalWickets(teamA.getTotalWickets() + 1);
                    if (index == teamA.getTeamMembers().size()) break outer;
                    striker = teamAPlayers.get(index++);
                } else if (runs == 6 || runs == 4 || runs == 2 || runs == 0 && teamA.getTotalScore() < target) {
                    striker.setRunsScored(striker.getRunsScored() + runs);
                    striker.setBallsFaced(striker.getBallsFaced() + 1);
                    teamA.setTotalScore(teamA.getTotalScore() + runs);

                } else if (runs == 3 || runs == 1 && teamA.getTotalScore() < target) {
                    striker.setRunsScored(striker.getRunsScored() + runs);
                    striker.setBallsFaced(striker.getBallsFaced() + 1);
                    Player temp = striker;
                    striker = runner;
                    runner = temp;
                    teamA.setTotalScore(teamA.getTotalScore() + runs);
                }
                if(teamA.getTotalScore()>=target)break outer;
            }
        }
        teamRepository.save(teamA);
        ESTeam temp = ESTeam.builder()
                .id(teamA.getId())
                .name(teamA.getName())
                .totalScore(teamA.getTotalScore())
                .totalBalls(teamA.getTotalBalls())
                .totalWickets(teamA.getTotalWickets())
                .teamMembers(teamA.getTeamMembers())
                .build();
        eSTeamRepository.save(temp);
    }
}
