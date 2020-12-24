package com.connect4.Connect4.DAO;

import java.util.List;

import com.connect4.Connect4.entity.Player;

public interface PlayerDAOInterface {

	List<Player> showAllPlayers();

	String save(Player thePlayer);

	Player findPlayerById(int theId);

	String saveMove(Player thePlayer);

	boolean IsValid(Player thePlayer);


}
