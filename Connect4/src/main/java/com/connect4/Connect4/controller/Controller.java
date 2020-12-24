package com.connect4.Connect4.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connect4.Connect4.DAO.PlayerDAOInterface;
import com.connect4.Connect4.entity.Player;

@RestController
@RequestMapping("/")
public class Controller {
	
	private PlayerDAOInterface playerDAOInterface;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public Controller(PlayerDAOInterface theplayerDAOInterface) {
		playerDAOInterface = theplayerDAOInterface;
	}
	
	
	@GetMapping("/home")
	public String home() {
		System.out.println("working");
		return "helloworld";
	}
	
	//returns list of all the players in the database
	@GetMapping("/players")
	public List<Player> showAllPlayers() {
		return playerDAOInterface.showAllPlayers();
	}
	
	@GetMapping("/players/{playerId}")
	public String showPlayerMoves(@PathVariable String playerId) {
		
		int theId = 0;
		try { 
            theId = Integer.parseInt(playerId);
	    } 
		catch (NumberFormatException e)  { 
            return "You are not entering a valid number";
		}
		
		//fetch the entry from the database
		
		Player thePlayer = playerDAOInterface.findPlayerById(theId); 
		if(thePlayer == null) {
			return "Player with playerId - " + playerId  + " not found!";
		}
		
		//show the moves
		String gamemoves = thePlayer.getMoves();
		String redmoves = "";
		String yellowmoves = "";
		String totalmoves = "";
		int i=0;
		for(i=0;i<gamemoves.length();i++) {
			if(i!=gamemoves.length()-1)
			{
				totalmoves+=gamemoves.charAt(i);
				totalmoves+=",";
			}
			else {
				totalmoves+=gamemoves.charAt(i);
			}
			if(i%2==0) {
				if(i!=gamemoves.length()-1) {
					redmoves+=gamemoves.charAt(i);
					redmoves+=",";
				}
				else {
					redmoves+=gamemoves.charAt(i);
				}
			}
			else {
				if(i!=gamemoves.length()-1) {
					yellowmoves+=gamemoves.charAt(i);
					yellowmoves+=",";
				}
				else {
					yellowmoves+=gamemoves.charAt(i);
				}				
			}
			
		}
		
		return "Game Moves: " + totalmoves + "\nYellow moves : " + yellowmoves + "\nRed moves: " + redmoves;
	}
	
	//creates a new player in the database
	@PostMapping("/players/start")
	public String GenerateToken(@RequestBody Player thePlayer) {
		
		//exceptional handling
		try { 
            Integer.parseInt(thePlayer.getMoves());
	    } 
		catch (NumberFormatException e)  { 
            return "You are not entering a valid move number";
		}
		
		thePlayer.setPlayer_id(0);
		
		boolean check = playerDAOInterface.IsValid(thePlayer);
		
		if(check) {
			playerDAOInterface.save(thePlayer);
		}
		
		else {
			return "Invalid Move";
		}
		
		return "New Game Generated with Id: " + String.valueOf(thePlayer.getPlayer_id()) + ". Have Fun :)";
		
	}
	
	//adding mapping for updating a particular Game entry in the database
	@PutMapping("/players")
	@Transactional
	public String MoveInComing(@RequestBody Player thePlayer) {
		
		Player PlayerCheck = playerDAOInterface.findPlayerById(thePlayer.getPlayer_id()); 
		if(PlayerCheck == null) {
			return "Player with playerId - " + thePlayer.getPlayer_id()  + " not found!";
		}
		
		try { 
            Integer.parseInt(thePlayer.getMoves());
	    } 
		catch (NumberFormatException e)  { 
            return "You are not entering a valid move number";
		}
		
		boolean check = playerDAOInterface.IsValid(thePlayer);
		
		String gameresponse = "Invalid Move";
		
		if(check) {
			List temp = entityManager.createQuery("select c.winner from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			String temp2 = temp.get(0).toString();
			if(temp2.length()!=0) {
				if(temp2.charAt(0)=='y') {
					return "This game is already won by : Yellow. Please play a new game."; 
				}
				else {
					return "This game is already won by : Red. Please play a new game.";
				}
				
			}
			gameresponse = playerDAOInterface.saveMove(thePlayer);
		}
		if(gameresponse=="Yellow Wins!!!" || gameresponse=="Red Wins!!!") {
			String winner;
			if(gameresponse=="Yellow Wins!!!") {
				winner = "y";
				thePlayer.setWinner("y");
			}
			else {
				winner = "r";
				thePlayer.setWinner("r");
			}
			Query query = entityManager.createQuery("update Player set winner = concat(winner,:validornot) where player_id=:playerId");
			query.setParameter("playerId", thePlayer.getPlayer_id());
			query.setParameter("validornot", winner);
			query.executeUpdate();
		}
		return gameresponse;
		
	}		
}
