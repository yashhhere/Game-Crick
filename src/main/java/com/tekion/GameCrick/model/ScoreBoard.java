package com.tekion.GameCrick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "scoreboard")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String playerName;
    private Long playerId;
    private int runsScored;
    private int ballsPlayed;
    private int wicketsTaken;
}
