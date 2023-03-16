package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.ESTeam;
import com.tekion.GameCrick.model.Team;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESTeamRepository extends ElasticsearchRepository<ESTeam,Long> {

}
