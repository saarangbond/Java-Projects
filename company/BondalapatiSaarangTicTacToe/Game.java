import java.awt.Graphics;
import java.awt.Font;

public class Game{
	private char[][] table;
	private char turn;
	
	public Game(){
	   table = new char[3][3];
	    for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				table[i][j] = '-';
			}
	    }
	    turn = 'X';
	}
	public void reset(){
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				table[i][j] = '-';
			}
	    }
	    turn = 'X';
	}
	public void printTable(){
	    for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
			   System.out.print(table[i][j] + "\t");
			}
			System.out.println();
		}
	 }

	 public boolean insertXO(int i, int j){
		boolean placed = false;
		
		if(table[i][j] == '-' && i < 3 && j < 3){
			table[i][j] = turn;
			placed = true;
			if(turn == 'X'){
			turn = 'O';
			}else if(turn == 'O'){
				turn = 'X';
			}
		}
		return placed;
	 }

	public boolean checkFull(){
	    boolean full = true;
	    for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				if(table[i][j] == '-'){
					full = false;
				}
			}
	    }
		if(checkTicTacToe() == 0){
			return full;
		}else{
			return false;
		}
	}

	public int checkTicTacToe(){
	    for(int i=0; i<3; i++) {
		    if(table[i][0] == table[i][1] && table[i][1] == table[i][2]) {
				if(table[i][0] == 'X'){
					return 1;
				}else if(table[i][0] == 'O'){
					return 2;
				}
			}
		}
	    for(int i=0; i<3; i++) {
		    if(table[0][i] == table[1][i] && table[2][i] == table[1][i]) {
				if(table[0][i] == 'X'){
					return 1;
				}else if(table[0][i] == 'O'){
					return 2;
				} 
		    }
	    }
		
	    if(table[0][0] == table[1][1] && table[1][1] == table[2][2]) {
			if(table[0][0] == 'X'){
			   return 1;
			}else if(table[0][0] == 'O'){
			   return 2;
			}
	    }
		
	    if(table[2][0] == table[1][1] && table[0][2] == table[1][1]) {
			if(table[2][0] == 'X'){
			   return 1;
			}else if(table[2][0] == 'O'){
			   return 2;
			}
	    }
		return 0;
	}
	
	public void playCompMove(){
		turn = 'O';
		int[] win = canWin();
		int[] block = canBlock();
		
		if(win[0] != -1){
			table[win[0]][win[1]] = turn;
		}else if(block[0] != -1){
			table[block[0]][block[1]] = turn;
		}else{
			while(true){
				int r = (int)(Math.random() * 3);
				int c = (int)(Math.random() * 3);
				if(table[r][c] == '-'){
					table[r][c] = turn;
					break;
				}
			}
		}
		
		turn = 'X';
	}
	
	public void drawMe(Graphics g){
		g.drawLine(300, 100, 300, 700);
		g.drawLine(500, 100, 500, 700);
		g.drawLine(100, 300, 700, 300);
		g.drawLine(100, 500, 700, 500);
		Font font1 = new Font("Arial", Font.BOLD, 100);
		g.setFont(font1);
		int x = 175;
		int y = 225;
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				g.drawString(table[i][j] + "", x, y);
				x += 200;
			}
			y += 200;
			x = 175;
		}
	}
	
	
	
	public int[] canWin(){
		int[] move = new int[2];
		move[0] = -1;
		move[1] = -1;
		int[][] counts = getCounts();
		for(int i = 0; i < counts.length; i++){
			if(counts[i][1] == 2 && counts[i][2] == 1){
				move = getDashMove(i);
				return move;
			}
		}
		
		return move;
	}
	public int[] canBlock(){
		int[] move = new int[2];
		move[0] = -1;
		move[1] = -1;
		int[][] counts = getCounts();
		for(int i = 0; i < counts.length; i++){
			if(counts[i][0] == 2 && counts[i][2] == 1){
				move = getDashMove(i);
				return move;
			}
		}
		
		return move;
	}


	private int[][] getCounts(){
		int[][] counts = new int[8][3];
		
		for(int i=0; i < table.length; i++) {
			for(int j = 0; j < table[i].length; j++){
				if(table[i][j] == 'X'){
					counts[i][0] ++;
					counts[j+3][0] ++;
					if(i == j){
						counts[6][0] ++;
					}
					if(i + j == 2){
						counts[7][0] ++;
					}
				}else if(table[i][j] == 'O'){
					counts[i][1] ++;
					counts[j+3][1] ++;
					if(i == j){
						counts[6][1] ++;
					}
					if(i + j == 2){
						counts[7][1] ++;
					}
				}else if(table[i][j] == '-'){
					counts[i][2] ++;
					counts[j+3][2] ++;
					if(i == j){
						counts[6][2] ++;
					}
					if(i + j == 2){
						counts[7][2] ++;
					}
				}
			}
		}
		
		return counts;
	}
	
	private int[] getDashMove(int index){
		int[] move = new int[2];
		if(index >= 0 && index <= 2){
			for(int j = 0; j < table[index].length; j++){
				if(table[index][j] == '-'){
					move[0] = index;
					move[1] = j;
				}
			}
		}else if(index >= 3 && index <= 5){
			for(int i = 0; i < table.length; i++){
				if(table[i][index - 3] == '-'){
					move[0] = i;
					move[1] = index - 3;
				}
			}
		}else if(index == 6){
			for(int i = 0; i < table.length; i++){
				if(table[i][i] == '-'){
					move[0] = i;
					move[1] = i;
				}
			}
		}else if(index == 7){
			for(int i = 0; i < table.length; i++){
				if(table[i][2-i] == '-'){
					move[0] = i;
					move[1] = 2-i;
				}
			}
		}
		return move;
	}

}