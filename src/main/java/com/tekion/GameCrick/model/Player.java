package com.tekion.GameCrick.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String playerName;
    private int wicketTaken;
    private int runsScored;
    private int ballsFaced;
    private int runABall;
    private boolean isOut;
    private Long teamId;

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
}
