package com.tekion.GameCrick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "view-score")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ESScoreboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Field(type = FieldType.Long)
    private Long id;
    @Field(type = FieldType.Text)
    private String playerName;
    @Field(type = FieldType.Long)
    private Long playerId;
    @Field(type = FieldType.Integer)
    private int runsScored;
    @Field(type = FieldType.Integer)
    private int ballsPlayed;
    @Field(type = FieldType.Integer)
    private int wicketsTaken;
}
