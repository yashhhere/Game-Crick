package com.tekion.GameCrick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "match-info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ESMatch {
    @Id
    @Field(type = FieldType.Long)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Field(type = FieldType.Long)
    private Long firstTeamId;
    @Field(type = FieldType.Long)
    private Long secondTeamId;
    @Field(type = FieldType.Integer)
    private int noOfOvers;
    @Field(type = FieldType.Integer)

    private int team1Total;
    @Field(type = FieldType.Integer)
    private int team2Total;
    @Field(type = FieldType.Text)

    private String winner;

}
