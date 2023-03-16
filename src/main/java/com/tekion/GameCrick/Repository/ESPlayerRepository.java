package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.ESPlayer;
import com.tekion.GameCrick.model.Player;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESPlayerRepository extends ElasticsearchRepository<ESPlayer,Long> {

}
