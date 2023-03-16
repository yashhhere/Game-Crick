package com.tekion.GameCrick.Service;
import com.tekion.GameCrick.Repository.ESScoreboardRepository;
import com.tekion.GameCrick.Repository.ScoreBoardRepository;
import com.tekion.GameCrick.model.ESScoreboard;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.model.ScoreBoard;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreboardService {
    @Autowired
    private ScoreBoardRepository scoreBoardRepository;
    @Autowired
    private ESScoreboardRepository eSScoreboardRepository;
    public String printScore(Team teamA, Team teamB, int numOvers){
        String winner;
        System.out.println("Player Name\t\tRuns Scored\t\tBalls faced");

        for(int i=0;i<teamA.getTeamMembers().size();i++){
            int bufferSize = 20 - teamA.getTeamMembers().get(i).getPlayerName().length();
            if(teamA.getTeamMembers().get(i).isOut()){
                System.out.print(teamA.getTeamMembers().get(i).getPlayerName());
                for(int j = 0; j < bufferSize; j++) {
                    System.out.print(" ");
                }
                System.out.println(teamA.getTeamMembers().get(i).getRunsScored() + "\t\t\t" + teamA.getTeamMembers().get(i).getBallsFaced());
            }
            else{
                if (teamA.getTeamMembers().get(i).getBallsFaced() != 0) {
                    System.out.print(teamA.getTeamMembers().get(i).getPlayerName());
                    System.out.print("*");
                    for(int j = 0; j < bufferSize-1; j++) {
                        System.out.print(" ");
                    }
                    System.out.println(teamA.getTeamMembers().get(i).getRunsScored() + "\t\t\t" + teamA.getTeamMembers().get(i).getBallsFaced());
                }
            }

        }

        System.out.print("Yet to Bat - ");
        for(int i=0;i<teamA.getTeamMembers().size();i++){
            if(teamA.getTeamMembers().get(i).getBallsFaced() == 0){
                System.out.print(teamA.getTeamMembers().get(i).getPlayerName() + ", ");
            }
        }
        System.out.println("\n");
        System.out.println(teamA.getName()+" scored "+teamA.getTotalScore() + "/" + teamA.getTotalWickets());
        System.out.println("\n");
        System.out.println("Player Name\t\tRuns Scored\t\tBalls faced");

        for(int i=0;i<teamB.getTeamMembers().size();i++){
            int bufferSize = 20 - teamB.getTeamMembers().get(i).getPlayerName().length();

            if(teamB.getTeamMembers().get(i).isOut()){
                System.out.print(teamB.getTeamMembers().get(i).getPlayerName());
                for(int j = 0; j < bufferSize; j++) {
                    System.out.print(" ");
                }
                System.out.println(teamB.getTeamMembers().get(i).getRunsScored() + "\t\t\t" + teamB.getTeamMembers().get(i).getBallsFaced());
            }
            else{
                if (teamB.getTeamMembers().get(i).getBallsFaced() != 0) {
                    System.out.print(teamB.getTeamMembers().get(i).getPlayerName() + "*");
                    for(int j = 0; j < bufferSize-1; j++) {
                        System.out.print(" ");
                    }
                    System.out.println(teamB.getTeamMembers().get(i).getRunsScored() + "\t\t\t" + teamB.getTeamMembers().get(i).getBallsFaced());
                }
            }
        }
        System.out.print("Yet to Bat - ");
        for(int i=0;i<teamB.getTeamMembers().size();i++){
            if(teamB.getTeamMembers().get(i).getBallsFaced() == 0){
                System.out.print(teamB.getTeamMembers().get(i).getPlayerName() + ", ");
            }
        }

        System.out.println("\n");
        System.out.println(teamB.getName()+" scored "+teamB.getTotalScore() + "/" + teamB.getTotalWickets());
        int target = teamA.getTotalScore()+1;

        if(teamB.getTotalScore()>=target){
            winner = teamB.getName();
            System.out.println(teamB.getName() + " have won the match by "+ (teamB.getTeamMembers().size()-1-teamB.getTotalWickets()) + " " +
                               "wickets.");
        }
        else {
            winner = teamA.getName();
            System.out.println(teamB.getName() + " have lost the match by "+(target -1 - teamB.getTotalScore()) + " " +
                               "runs.");
        }
        saveScore(teamA);
        saveScore(teamB);
        return winner;
}

    public void saveScore(Team teamA){
        for(Player player : teamA.getTeamMembers()){
            ScoreBoard scoreBoard = ScoreBoard.builder()
                    .playerId(player.getId())
                    .playerName(player.getPlayerName())
                    .runsScored(player.getRunsScored())
                    .ballsPlayed(player.getBallsFaced())
                    .wicketsTaken(player.getWicketTaken())
                    .build();
            scoreBoardRepository.save(scoreBoard);
            ESScoreboard temp = ESScoreboard.builder()
                                                     .playerId(player.getId())
                                                     .playerName(player.getPlayerName())
                                                     .runsScored(player.getRunsScored())
                                                     .ballsPlayed(player.getBallsFaced())
                                                     .wicketsTaken(player.getWicketTaken())
                                                     .build();
            eSScoreboardRepository.save(temp);
        }
    }

    public ScoreBoard getScoreBoard(Long playerId){
        List<ScoreBoard> scoreBoards = (ArrayList<ScoreBoard>) scoreBoardRepository.findAll();
        for(ScoreBoard scoreBoard : scoreBoards){
            if(scoreBoard.getPlayerId().equals(playerId))
                return scoreBoard;
        }
        return null;
    }
}
