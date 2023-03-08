package com.tekion.GameCrick.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import com.tekion.GameCrick.model.Team;
import com.tekion.GameCrick.model.Player;
import com.tekion.GameCrick.view.Scoreboard;
@SpringBootApplication
public class GameCrickApplication {
	public static void main(String[] args) {
		int numOvers;
		Team teamA = new Team();
		Team teamB = new Team();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of team one: ");
		teamA.setTeamName(sc.nextLine());
		System.out.println("Enter the name of team two: ");
		teamB.setTeamName(sc.nextLine());
		System.out.println("Enter the number of overs you want to play: ");
		numOvers = sc.nextInt();sc.nextLine();
		for(int i=0;i<11;i++){
			Player Pi = new Player(teamA.getTeamName()+(i+1));
			teamA.getTeamMembers().add(Pi);
		}

		for(int i=0;i<11;i++){
			Player Pi = new Player(teamB.getTeamName()+(i+1));
			teamB.getTeamMembers().add(Pi);
		}
		GameManager newGame = new GameManager();
		newGame.play(teamA, teamB, numOvers);
		Scoreboard sb = new Scoreboard();
		sb.printScore(teamA, teamB, numOvers);
	}
}
