package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.ESScoreboard;
import com.tekion.GameCrick.model.ScoreBoard;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESScoreboardRepository extends ElasticsearchRepository<ESScoreboard,Long> {

}
