package com.tekion.GameCrick.Service;

import com.tekion.GameCrick.Repository.ESPlayerRepository;
import com.tekion.GameCrick.Repository.PlayerRepository;
import com.tekion.GameCrick.model.ESPlayer;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ESPlayerRepository eSPlayerRepository;

    public void add(List<Player> players){
        for(Player player : players){
            ESPlayer temp = ESPlayer.builder()
                    .id(player.getId())
                    .playerName(player.getPlayerName())
                    .wicketTaken(player.getWicketTaken())
                    .ballsFaced(player.getBallsFaced())
                    .runsScored(player.getRunsScored())
                    .isOut(player.isOut())
                    .teamId(player.getTeamId())
                                    .build();
            playerRepository.save(player);
            eSPlayerRepository.save(temp);
        }
    }

    public void setPlayers(Team teamA, Team teamB){
        List<Player> players = (ArrayList<Player>) playerRepository.findAll();
        for(Player player : players){
            player.setWicketTaken(0);
            player.setBallsFaced(0);
            player.setRunsScored(0);
            if(player.getTeamId().equals(teamA.getId())){
                teamA.getTeamMembers().add(player);
            }
            if(player.getTeamId().equals(teamB.getId())){
                teamB.getTeamMembers().add(player);
            }
        }
    }

    public Player getPlayer(Long id){
        return playerRepository.findById(id).orElse(null);
    }
}
