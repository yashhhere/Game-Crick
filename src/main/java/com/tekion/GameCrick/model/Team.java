package com.tekion.GameCrick.model;
import java.util.ArrayList;
import com.tekion.GameCrick.model.Player;
public class Team {
    String teamName;
    int totalScore;
    int totalWickets;
    int totalBalls;
    public ArrayList<Player> teamMembers = new ArrayList<Player>();

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls = totalBalls;
    }

    public ArrayList<Player> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<Player> teamMembers) {
        this.teamMembers = teamMembers;
    }
    public void addWickets(){
        totalWickets++;
    }
    public void addRuns(int runs){
        totalScore+=runs;
    }
}
