package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long>{

}
