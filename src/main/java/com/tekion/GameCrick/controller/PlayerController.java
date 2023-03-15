package com.tekion.GameCrick.controller;

import com.tekion.GameCrick.Service.PlayerService;
import com.tekion.GameCrick.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public void add(@RequestBody List<Player> players){
        playerService.add(players);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable Long id){
        return playerService.getPlayer(id);
    }
}
