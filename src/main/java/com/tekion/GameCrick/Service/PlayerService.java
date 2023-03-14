package com.tekion.GameCrick.Service;

import com.tekion.GameCrick.Repository.PlayerRepository;
import com.tekion.GameCrick.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public void add(Player player){
        playerRepository.save(player);
    }

    public Player getPlayer(Long id){
        return playerRepository.findById(id).orElse(null);
    }
}
