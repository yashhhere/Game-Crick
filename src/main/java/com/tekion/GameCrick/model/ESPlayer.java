package com.tekion.GameCrick.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "player-data")
@Data
@Builder
public class ESPlayer {
    @org.springframework.data.annotation.Id
    @Field(type = FieldType.Long)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Field(type = FieldType.Text)
    private String playerName;
    @Transient
    @Field(type = FieldType.Integer)
    private int wicketTaken;
    @Field(type = FieldType.Integer)
    private int runsScored;
    @Field(type = FieldType.Integer)
    private int ballsFaced;
    @Transient
    @Field(type = FieldType.Integer)
    private int runABall;
    @Transient
    @Field(type = FieldType.Boolean)
    private boolean isOut;
    @Field(type = FieldType.Long)
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
