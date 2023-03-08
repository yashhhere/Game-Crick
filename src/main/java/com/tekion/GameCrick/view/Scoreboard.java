package com.tekion.GameCrick.view;
import com.tekion.GameCrick.model.Team;
import java.util.Formatter;

public class Scoreboard {
    public void printScore(Team teamA, Team teamB, int numOvers){
        System.out.println("Player Name\t\tRuns Scored\t\tBalls faced");

        for(int i=0;i<11;i++){
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
        for(int i=0;i<11;i++){
            if(teamA.getTeamMembers().get(i).getBallsFaced() == 0){
                System.out.print(teamA.getTeamMembers().get(i).getPlayerName() + ", ");
            }
        }
        System.out.println("\n");
        System.out.println(teamA.getTeamName()+" scored "+teamA.getTotalScore() + "/" + teamA.getTotalWickets());
        System.out.println("\n");
        System.out.println("Player Name\t\tRuns Scored\t\tBalls faced");

        for(int i=0;i<11;i++){
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
        for(int i=0;i<11;i++){
            if(teamB.getTeamMembers().get(i).getBallsFaced() == 0){
                System.out.print(teamB.getTeamMembers().get(i).getPlayerName() + ", ");
            }
        }

        System.out.println("\n");
        System.out.println(teamB.getTeamName()+" scored "+teamB.getTotalScore() + "/" + teamB.getTotalWickets());
        int target = teamA.getTotalScore()+1;

        if(teamB.getTotalScore()>=target && teamB.getTotalWickets()<10 && teamB.getTotalBalls()<=numOvers*6){
            System.out.println(teamB.getTeamName() + " have won the match by "+ (10-teamB.getTotalWickets()) + " " +
                               "wickets.");
        }
        else {
            System.out.println(teamB.getTeamName() + " have lost the match by "+(target - teamB.getTotalScore()) + " runs.");
        }

    }
}
