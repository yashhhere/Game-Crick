package com.tekion.GameCrick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "matches" , indexes = {@Index(name = "index_winningTeam", columnList = "winner")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long firstTeamId;
    private Long secondTeamId;
    private int noOfOvers;

    private int team1Total;
    private int team2Total;

    private String winner;

}
