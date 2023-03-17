package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.ESMatch;
import com.tekion.GameCrick.model.Match;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ESMatchRepository extends ElasticsearchRepository<ESMatch,Long> {
}