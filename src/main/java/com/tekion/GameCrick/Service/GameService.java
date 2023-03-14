package com.tekion.GameCrick.Service;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private InningService inningService;
    private static final int INT_MAX = (int)1e9;
    public void play(Team teamA, Team teamB, int numOvers){
        inningService.playInning(teamA, numOvers, INT_MAX);
        inningService.playInning(teamB, numOvers, teamA.getTotalScore()+1);
    }
}
