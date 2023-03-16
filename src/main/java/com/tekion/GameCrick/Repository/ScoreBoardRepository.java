package com.tekion.GameCrick.Repository;

import com.tekion.GameCrick.model.ScoreBoard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreBoardRepository extends CrudRepository<ScoreBoard,Long> {

}
