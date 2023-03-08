package com.tekion.GameCrick.controller;
import com.tekion.GameCrick.model.Team;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.view.Scoreboard;
public class GameManager {
    private static final int INT_MAX = (int)1e9;
    public void play(Team teamA, Team teamB, int numOvers){
        Inning i1 = new Inning();
        Inning i2 = new Inning();
        i1.playInning(teamA, numOvers, INT_MAX);
        i2.playInning(teamB, numOvers, teamA.getTotalScore()+1);
    }
}
