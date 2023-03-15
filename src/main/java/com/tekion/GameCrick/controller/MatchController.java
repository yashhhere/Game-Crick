package com.tekion.GameCrick.controller;

import com.tekion.GameCrick.Service.GameService;
import com.tekion.GameCrick.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public void startMatch(@RequestBody Match match){
        gameService.prepMatch(match);
    }

    @GetMapping("/get/{id}")
    public Match get(@PathVariable Long id){
        return gameService.getMatch(id);
    }
}
