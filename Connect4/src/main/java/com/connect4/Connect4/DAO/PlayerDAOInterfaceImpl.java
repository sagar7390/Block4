package com.connect4.Connect4.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.connect4.Connect4.Board.Board;
import com.connect4.Connect4.entity.Player;

@Repository
public class PlayerDAOInterfaceImpl implements PlayerDAOInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private Board board;
	
	
	@Override
	@Transactional
	public List<Player> showAllPlayers() {
				
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("from Player", Player.class);
			
		//execute query and get result list
		List<Player> players = theQuery.getResultList();
		
		return players;
	}
	
	@Override
	@Transactional
	public String save(Player thePlayer) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save Player
		currentSession.saveOrUpdate(thePlayer);
		
		String column = thePlayer.getMoves();
		
		int i=Integer.parseInt(column);
		
		int Row;
		
		int Column;
		
		String gameresponse = "";
		
		if(i==1) {
			Query query1 = entityManager.createQuery("update Player set column1_total = column1_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			
			List query2 = entityManager.createQuery("select c.column1_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			
			String tempQuery = String.valueOf(query2.get(0)); 
			
			Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
			query3.setParameter("playerId", thePlayer.getPlayer_id());
			query3.setParameter("newvalue", tempQuery);
			query3.executeUpdate();
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			
			gameresponse = board.InitializeBoard(query4,query5);

		}
		
		else if(i==2) {
			Query query1 = entityManager.createQuery("update Player set column2_total = column2_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			
			List query2 = entityManager.createQuery("select c.column2_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			
			String tempQuery = String.valueOf(query2.get(0)); 
			
			Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
			query3.setParameter("playerId", thePlayer.getPlayer_id());
			query3.setParameter("newvalue", tempQuery);
			query3.executeUpdate();
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			
			gameresponse = board.InitializeBoard(query4,query5);
		}
		
		else if(i==3) {
			Query query1 = entityManager.createQuery("update Player set column3_total = column3_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			
			List query2 = entityManager.createQuery("select c.column3_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			String tempQuery = String.valueOf(query2.get(0)); 
			
			Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
			query3.setParameter("playerId", thePlayer.getPlayer_id());
			query3.setParameter("newvalue", tempQuery);
			query3.executeUpdate();
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();


			gameresponse = board.InitializeBoard(query4,query5);
		}
		else if(i==4) {
			Query query1 = entityManager.createQuery("update Player set column4_total = column4_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			
			List query2 = entityManager.createQuery("select c.column4_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			
			String tempQuery = String.valueOf(query2.get(0)); 
			
			Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
			query3.setParameter("playerId", thePlayer.getPlayer_id());
			query3.setParameter("newvalue", tempQuery);
			query3.executeUpdate();
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);

		}
		
		else if(i==5) {
			Query query1 = entityManager.createQuery("update Player set column5_total = column5_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			
			List query2 = entityManager.createQuery("select c.column5_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			String tempQuery = String.valueOf(query2.get(0)); 
			
			Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
			query3.setParameter("playerId", thePlayer.getPlayer_id());
			query3.setParameter("newvalue", tempQuery);
			query3.executeUpdate();
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);

		}
		
		else if(i==6) {
			Query query1 = entityManager.createQuery("update Player set column6_total = column6_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			
			List query2 = entityManager.createQuery("select c.column6_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			String tempQuery = String.valueOf(query2.get(0)); 
			
			Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
			query3.setParameter("playerId", thePlayer.getPlayer_id());
			query3.setParameter("newvalue", tempQuery);
			query3.executeUpdate();
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);
			
		}
		
		return gameresponse;
	}
	
	@Override
	@Transactional
	public Player findPlayerById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Player thePlayer  = currentSession.get(Player.class, theId);
		
		// return the employee
		return thePlayer;
	}

	@Override
	@Transactional
	public String saveMove(Player thePlayer) {
				
		String column = thePlayer.getMoves();
		
		int i=Integer.parseInt(column);
		
		String gameresponse = "";
		
		if(i==1) {
			Query query1 = entityManager.createQuery("update Player set column1_total = column1_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			List query2 = entityManager.createQuery("select c.column1_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			int temp9 = (int) query2.get(0);
			String tempQuery = String.valueOf(query2.get(0));
			int tempval = Integer.parseInt(tempQuery);
			System.out.println("testing getter: " + temp9);
			if(tempval<=6) {
				Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
				query3.setParameter("playerId", thePlayer.getPlayer_id());
				query3.setParameter("newvalue", tempQuery);
				query3.executeUpdate();
				
				Query query = entityManager.createQuery("update Player set moves = concat(moves,:newmoves) where player_id=:playerId");
				query.setParameter("playerId", thePlayer.getPlayer_id());
				query.setParameter("newmoves", thePlayer.getMoves());
				query.executeUpdate();
			}
			else {
				return "Invalid Move!!!";
			}
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);
			
		}
		
		if(i==2) {
			Query query1 = entityManager.createQuery("update Player set column2_total =column2_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();

			List query2 = entityManager.createQuery("select c.column2_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			int temp9 = (int) query2.get(0);
			String tempQuery = String.valueOf(query2.get(0));
			int tempval = Integer.parseInt(tempQuery);
			System.out.println("testing getter: " + temp9);
			if(tempval<=6) {
				Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
				query3.setParameter("playerId", thePlayer.getPlayer_id());
				query3.setParameter("newvalue", tempQuery);
				query3.executeUpdate();
				
				Query query = entityManager.createQuery("update Player set moves = concat(moves,:newmoves) where player_id=:playerId");
				query.setParameter("playerId", thePlayer.getPlayer_id());
				query.setParameter("newmoves", thePlayer.getMoves());
				query.executeUpdate();
			}
			else {
				return "Invalid Move!!!";
			}
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			
			gameresponse = board.InitializeBoard(query4,query5);
			

		}
		
		if(i==3) {
			Query query1 = entityManager.createQuery("update Player set column3_total =column3_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			List query2 = entityManager.createQuery("select c.column3_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			int temp9 = (int) query2.get(0);
			String tempQuery = String.valueOf(query2.get(0));
			int tempval = Integer.parseInt(tempQuery);
			System.out.println("testing getter: " + temp9);
			if(tempval<=6) {
				Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
				query3.setParameter("playerId", thePlayer.getPlayer_id());
				query3.setParameter("newvalue", tempQuery);
				query3.executeUpdate();
				
				Query query = entityManager.createQuery("update Player set moves = concat(moves,:newmoves) where player_id=:playerId");
				query.setParameter("playerId", thePlayer.getPlayer_id());
				query.setParameter("newmoves", thePlayer.getMoves());
				query.executeUpdate();
			}
			else {
				return "Invalid Move!!!";
			}
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);
			
		}
		
		
		if(i==4) {
			Query query1 = entityManager.createQuery("update Player set column4_total =column4_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			List query2 = entityManager.createQuery("select c.column4_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			int temp9 = (int) query2.get(0);
			String tempQuery = String.valueOf(query2.get(0));
			int tempval = Integer.parseInt(tempQuery);
			System.out.println("testing getter: " + temp9);
			if(tempval<=6) {
				Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
				query3.setParameter("playerId", thePlayer.getPlayer_id());
				query3.setParameter("newvalue", tempQuery);
				query3.executeUpdate();
				
				Query query = entityManager.createQuery("update Player set moves = concat(moves,:newmoves) where player_id=:playerId");
				query.setParameter("playerId", thePlayer.getPlayer_id());
				query.setParameter("newmoves", thePlayer.getMoves());
				query.executeUpdate();
			}
			else {
				return "Invalid Move!!!";
			}
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);
			
		}
		
		if(i==5) {
			Query query1 = entityManager.createQuery("update Player set column5_total =column5_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			List query2 = entityManager.createQuery("select c.column5_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			int temp9 = (int) query2.get(0);
			String tempQuery = String.valueOf(query2.get(0));
			int tempval = Integer.parseInt(tempQuery);
			System.out.println("testing getter: " + temp9);
			if(tempval<=6) {
				Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
				query3.setParameter("playerId", thePlayer.getPlayer_id());
				query3.setParameter("newvalue", tempQuery);
				query3.executeUpdate();
				
				Query query = entityManager.createQuery("update Player set moves = concat(moves,:newmoves) where player_id=:playerId");
				query.setParameter("playerId", thePlayer.getPlayer_id());
				query.setParameter("newmoves", thePlayer.getMoves());
				query.executeUpdate();
			}
			else {
				return "Invalid Move!!!";
			}
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);
		}
		
		if(i==6) {
			Query query1 = entityManager.createQuery("update Player set column6_total =column6_total + 1 where player_id=:playerId");
			
			query1.setParameter("playerId", thePlayer.getPlayer_id());
			query1.executeUpdate();
			
			List query2 = entityManager.createQuery("select c.column6_total from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();
			int temp9 = (int) query2.get(0);
			String tempQuery = String.valueOf(query2.get(0));
			int tempval = Integer.parseInt(tempQuery);
			System.out.println("testing getter: " + temp9);
			if(tempval<=6) {
				Query query3 = entityManager.createQuery("update Player set row_values = concat(row_values,:newvalue) where player_id=:playerId");
				query3.setParameter("playerId", thePlayer.getPlayer_id());
				query3.setParameter("newvalue", tempQuery);
				query3.executeUpdate();
				
				Query query = entityManager.createQuery("update Player set moves = concat(moves,:newmoves) where player_id=:playerId");
				query.setParameter("playerId", thePlayer.getPlayer_id());
				query.setParameter("newmoves", thePlayer.getMoves());
				query.executeUpdate();
			}
			else {
				return "Invalid Move!!!";
			}
			
			List query4 = entityManager.createQuery("select c.row_values from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			List query5 = entityManager.createQuery("select c.moves from Player c where c.player_id=:playerId").setParameter("playerId", thePlayer.getPlayer_id()).getResultList();

			gameresponse = board.InitializeBoard(query4,query5);
			
		}
			
		return gameresponse;
		
	}
	
	@Override
	@Transactional
	public boolean IsValid(Player thePlayer) {
	
		boolean isValid = false;
		int check=Integer.parseInt(thePlayer.getMoves());  
		if(check>=1 && check<=7) {
			isValid = true;	
		}
		
		if(isValid) {
			return isValid;
		}
			
		return isValid;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
