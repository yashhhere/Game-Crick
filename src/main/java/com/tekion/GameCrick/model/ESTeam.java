package com.tekion.GameCrick.model;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "team-info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ESTeam {
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Integer)
    int totalScore;
    @Field(type = FieldType.Integer)
    int totalWickets;
    @Field(type = FieldType.Integer)
    int totalBalls;
    @Transient
    @Field(type = FieldType.Object)
    public ArrayList<Player> teamMembers = new ArrayList<Player>();
}
