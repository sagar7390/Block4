package com.connect4.Connect4.Board;

import java.util.List;

import org.springframework.stereotype.Component; 

@Component
public class Board {

	public String InitializeBoard(List query4, List query5) {
		String[][] board = new String[6][7];
		for(int q1=0;q1<6;q1++) {
			for(int q2=0;q2<7;q2++) {
				board[q1][q2] = "empty";
			}
		}
		System.out.println("row_values - " + query4);
		System.out.println("moves - "+ query5);
		String row = query4.get(0).toString();
		System.out.println("testing inside board:" + row);
		String column = query5.get(0).toString();
		int i = 0;
		String chance = "";
		while(i<row.length()){
			int rowvalue = row.charAt(i) - '0';
			int columnvalue = 0;
			System.out.println("row: "+rowvalue);
			System.out.println("column: "+columnvalue);
			columnvalue = column.charAt(i) - '0';
			if(i==0) {
					chance = "y";
			}
			else {
				if(chance=="y")
					chance = "r";
				else
					chance = "y";
			}
			board[6-rowvalue][columnvalue-1] = chance;
			i++;
			
		}
		ShowBoard(board);
		String whowins_H = CheckHorizontal(board);
		String whowins_V = CheckVertical(board);
		String whowins_D = CheckDiagonal(board);
		if(whowins_H!="This is a Valid Move.Play next move!!!") {
			return whowins_H;
		}
		if(whowins_V!="This is a Valid Move.Play next move!!!") {
			return whowins_V;
		}
		if(whowins_D!="This is a Valid Move.Play next move!!!") {
			return whowins_D;
		}
		else {
			return "This is a Valid Move.Play next move!!!";
		}
		
	}
	
	public void ShowBoard(String[][] board) {
		System.out.println("Board Position");
		int i,j;
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	

	private String CheckHorizontal(String[][] board) {
		int i,j;
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				String temp = "";
				if(j+3<7) {
					temp+=board[i][j];
					temp+=board[i][j+1];
					temp+=board[i][j+2];
					temp+=board[i][j+3];
					if(temp.equals("yyyy")) {
						return "Yellow Wins!!!";
					}
					else if(temp.equals("rrrr")) {
						return "Red Wins!!!";
					}
				}
			}
		
		}
		return "This is a Valid Move.Play next move!!!";
	}
	
	private String CheckVertical(String[][] board) {
		int i,j;
		for(i=0;i<7;i++) {
			for(j=0;j<6;j++) {
				String temp = "";
				if(j+3<6) {
					temp+=board[j][i];
					temp+=board[j+1][i];
					temp+=board[j+2][i];
					temp+=board[j+3][i];
					if(temp.equals("yyyy")) {
						return "Yellow Wins!!!";
					}
					else if(temp.equals("rrrr")) {
						return "Red Wins!!!";
					}
				}
			}
		
		}
		return "This is a Valid Move.Play next move!!!";
	}
	
	private String CheckDiagonal(String[][] board) {
		int i,j;
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				String temp = "";
				if(i+3<6 && j+3<7) {
					temp+=board[i][j];
					temp+=board[i+1][j+1];
					temp+=board[i+2][j+2];
					temp+=board[i+3][j+3];
					if(temp.equals("yyyy")) {
						return "Yellow Wins!!!";
					}
					else if(temp.equals("rrrr")) {
						return "Red Wins!!!";
					}
				}
			}
		}
		return "This is a Valid Move.Play next move!!!";
	}

	

}
