package com.connect4.Connect4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="connect4_player_info")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="player_id")
	private int player_id;
	
	@Column(name="moves")
	private String moves;
	
	@Column(name="winner")
	private String winner;
	
	@Column(name="row_values")
	private String row_values;
	
	@Column(name="column1_total")
	private int column1_total;
	
	@Column(name="column2_total")
	private int column2_total;
	
	@Column(name="column3_total")
	private int column3_total;
	
	@Column(name="column4_total")
	private int column4_total;
	
	@Column(name="column5_total")
	private int column5_total;
	
	@Column(name="column6_total")
	private int column6_total;
	
	
	public Player() {
		
	}


	public String getWinner() {
		return winner;
	}


	public void setWinner(String winner) {
		this.winner = winner;
	}


	public int getPlayer_id() {
		return player_id;
	}


	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}


	public String getMoves() {
		return moves;
	}


	public void setMoves(String moves) {
		this.moves = moves;
	}


	public String getRow_values() {
		return row_values;
	}


	public void setRow_values(String row_values) {
		this.row_values = row_values;
	}


	public int getColumn1_total() {
		return column1_total;
	}


	public void setColumn1_total(int column1_total) {
		this.column1_total = column1_total;
	}


	public int getColumn2_total() {
		return column2_total;
	}


	public void setColumn2_total(int column2_total) {
		this.column2_total = column2_total;
	}


	public int getColumn3_total() {
		return column3_total;
	}


	public void setColumn3_total(int column3_total) {
		this.column3_total = column3_total;
	}


	public int getColumn4_total() {
		return column4_total;
	}


	public void setColumn4_total(int column4_total) {
		this.column4_total = column4_total;
	}


	public int getColumn5_total() {
		return column5_total;
	}


	public void setColumn5_total(int column5_total) {
		this.column5_total = column5_total;
	}


	public int getColumn6_total() {
		return column6_total;
	}


	public void setColumn6_total(int column6_total) {
		this.column6_total = column6_total;
	}


	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", moves=" + moves + ", winner=" + winner + ", row_values="
				+ row_values + ", column1_total=" + column1_total + ", column2_total=" + column2_total
				+ ", column3_total=" + column3_total + ", column4_total=" + column4_total + ", column5_total="
				+ column5_total + ", column6_total=" + column6_total + "]";
	}


	
	

	
	
	
	
}
