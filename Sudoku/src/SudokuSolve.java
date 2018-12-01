

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;


public class SudokuSolve extends JPanel{

	static int[][] sudoku = {{1, 0, 0, 0, 0, 7, 0, 9, 0},
            				 {0, 3, 0, 0, 2, 0, 0, 0, 8},
            				 {0, 0, 9, 6, 0, 0, 5, 0, 0}, 
            				 {0, 0, 5, 3, 0, 0, 9, 0, 0},
            				 {0, 1, 0, 0, 8, 0, 0, 0, 2},
            				 {6, 0, 0, 0, 0, 4, 0, 0, 0},
            				 {3, 0, 0, 0, 0, 0, 0, 1, 0},
            				 {0, 4, 0, 0, 0, 0, 0, 0, 7},
            				 {0, 0, 7, 0, 0, 0, 3, 0, 0}};

	final int[][] originalSudoku = {{1, 0, 0, 0, 0, 7, 0, 9, 0},
			 						{0, 3, 0, 0, 2, 0, 0, 0, 8},
			 						{0, 0, 9, 6, 0, 0, 5, 0, 0}, 
			 						{0, 0, 5, 3, 0, 0, 9, 0, 0},
			 						{0, 1, 0, 0, 8, 0, 0, 0, 2},
			 						{6, 0, 0, 0, 0, 4, 0, 0, 0},
			 						{3, 0, 0, 0, 0, 0, 0, 1, 0},
			 						{0, 4, 0, 0, 0, 0, 0, 0, 7},
			 						{0, 0, 7, 0, 0, 0, 3, 0, 0}};
			
			
	static int total = 0;
	
	public static void main(String[] args) {
		System.out.println(sudoku.length);
		System.out.println(sudoku[5].length);
		System.out.println(sudoku[0].length);
		SudokuSolve a = new SudokuSolve();
		System.out.println(a.Solve());	
		System.out.println("\n \n \n");
		a.printSudoku();
		System.out.println("");
		System.out.println(total);
	}
	
	
	public boolean Solve(){
		for(int i = 0; i < sudoku.length; i++){
			for (int j = 0; j < sudoku.length; j ++){
				if(sudoku[i][j] == 0){
					for(int n = 1; n < (sudoku.length + 1); n++){
						if(check(n, i, j)){
							sudoku[i][j] = n;
							System.out.println(n);
							printSudoku();
							//pause();
							repaint();
							total += 1;
							if(Solve()){
								return true;
							}
						}
					}
					sudoku[i][j] = 0;
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean check(int number, int row, int coll) {	
		for (int i = 0; i < sudoku.length; i++){
			if (sudoku[row][i] == number){
				return false;
			}
			if (sudoku[i][coll] == number){
				return false;
			}
			int r = (int) ((row/3)) * 3;
			int p = (int) ((coll/3)) * 3;
							
			for(int j = 0; j < Math.sqrt(sudoku.length); j++){
				for (int k = 0; k < Math.sqrt(sudoku.length); k++){
					if(number == sudoku[r + j][p + k]){
						return false;
					}
				}
			}			
		}		
		return true;
	}


	public void printSudoku(){
		for(int row=0;row<9;row++){
			for(int column=0;column<9;column++){
				if (column==2||column==5){
					System.out.print((sudoku[row][column]==0)? " |":sudoku[row][column] + "|");
				}else{
					System.out.print((sudoku[row][column]==0)?"  ":sudoku[row][column] + " ");
				}
			}
		if(row==2||row==5){
			System.out.println();
			System.out.print("-----------------");
		}
		System.out.println();
		}
	}
	
	public static void pause(){
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.BLACK);
		
		g.setFont(new Font("Monospace", Font.PLAIN, 100));
		
		g.fillRect(100, 0, 3, 1000);
		g.fillRect(210, 0, 3, 1000);
		g.fillRect(320, 0, 10, 1000);
		g.fillRect(430, 0, 3, 1000);
		g.fillRect(540, 0, 3, 1000);
		g.fillRect(650, 0, 10, 1000);
		g.fillRect(760, 0, 3, 1000);
		g.fillRect(870, 0, 3, 1000);
		
		g.fillRect(0, 110, 1000, 3);
		g.fillRect(0, 220, 1000, 3);
		g.fillRect(0, 330, 1000, 10);
		g.fillRect(0, 440, 1000, 3);
		g.fillRect(0, 550, 1000, 3);
		g.fillRect(0, 660, 1000, 10);
		g.fillRect(0, 770, 1000, 3);
		g.fillRect(0, 880, 1000, 3);
		
		for(int row = 0; row<sudoku.length; row++){
			for(int col = 0; col<sudoku.length; col++){
				if(sudoku[col][row] != 0){
					g.drawString(Integer.toString(sudoku[col][row]), (row*110) + 20, (col*110)+100);
				}
			}
		}
		g.setColor(Color.RED);
		for(int row = 0; row<originalSudoku.length; row++){
			for(int col = 0; col<originalSudoku.length; col++){
				if(originalSudoku[col][row] != 0){
					g.drawString(Integer.toString(originalSudoku[col][row]), (row*110) + 20, (col*110)+100);
				}
			}
		}
	}
}
