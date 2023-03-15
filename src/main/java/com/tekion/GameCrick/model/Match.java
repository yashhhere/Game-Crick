package com.tekion.GameCrick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "matches")
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long firstTeamId;
    private Long secondTeamId;
    private Long winner;
    private int noOfOvers;

}
