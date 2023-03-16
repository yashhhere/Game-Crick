package com.tekion.GameCrick.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Player", indexes = {@Index(name = "index_playerName", columnList = "playerName")})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String playerName;
    @Transient
    private int wicketTaken;
    private int runsScored;
    private int ballsFaced;
    @Transient
    private int runABall;
    @Transient
    private boolean isOut;
    private Long teamId;

    public int getRunABall(String playerKind) {
        if(playerKind.equals("batsman")){
            return (int)(Math.random()*8);
        }
        else if(playerKind.equals("bowler")){
            return (int)(Math.random()*10);
        }
        return 0;
    }
}
