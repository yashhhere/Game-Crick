package com.tekion.GameCrick.controller;

import com.tekion.GameCrick.Service.ScoreboardService;
import com.tekion.GameCrick.model.ScoreBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scoreboard")
public class ScoreBoardController{
    @Autowired
    private ScoreboardService scoreboardService;

    @GetMapping("/{playerId}")
    public ScoreBoard getScoreBoard(@PathVariable Long playerId){
        return scoreboardService.getScoreBoard(playerId);
    }

}
