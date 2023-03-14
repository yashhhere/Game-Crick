package com.tekion.GameCrick.model;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String teamName;
    int totalScore;
    int totalWickets;
    int totalBalls;
    @Transient
    public ArrayList<Player> teamMembers = new ArrayList<Player>();
}
