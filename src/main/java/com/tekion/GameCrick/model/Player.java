package com.tekion.GameCrick.model;

public class Player {
    private String playerName;
    private int wicketTaken;
    private int runsScored;
    private int ballsFaced;

    public int getRunABall(String playerKind) {
        if(playerKind.equals("batsman")){
            //   Score sc = new Score();
            //   return (int)sc.nextSkewedBoundedDouble(-2, 8, 7);
            return (int)(Math.random()*8);
        }
        else if(playerKind.equals("bowler")){
            //   Score sc = new Score();
            //   return (int)sc.nextSkewedBoundedDouble(-2, 8, -1);
            return (int)(Math.random()*9);
        }
        return 0;
    }

    public void setRunABall(int runABall) {
        this.runABall = runABall;
    }

    private int runABall;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getWicketTaken() {
        return wicketTaken;
    }

    public void setWicketTaken(int wicketTaken) {
        this.wicketTaken = wicketTaken;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    private boolean isOut;
    public Player(String name){
        this.playerName = name;
    }

}
