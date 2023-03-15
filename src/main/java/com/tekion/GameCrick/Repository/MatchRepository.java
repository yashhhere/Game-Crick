package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long>{
}
