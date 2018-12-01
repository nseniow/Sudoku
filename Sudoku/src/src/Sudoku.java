package src;

public class Sudoku{

	static int[][] sudoku = {{8, 0, 0, 0, 0, 0, 0, 0, 0},
            				 {0, 0, 3, 6, 0, 0, 0, 0, 0},
            				 {0, 7, 0, 0, 9, 0, 2, 0, 0}, 
            				 {0, 5, 0, 0, 0, 7, 0, 0, 0},
            				 {0, 0, 0, 0, 4, 5, 7, 0, 0},
            				 {0, 0, 0, 1, 0, 0, 0, 3, 0},
            				 {0, 0, 1, 0, 0, 0, 0, 6, 8},
            				 {0, 0, 8, 5, 0, 0, 0, 1, 0},
            				 {0, 9, 0, 0, 0, 0, 4, 0, 0}};
	
	public static void main(String[] args) {
		Sudoku a = new Sudoku();
		long millis = System.currentTimeMillis() % 1000;
		a.Solve();
		long millis2 = System.currentTimeMillis() % 1000;
		System.out.println("\n \n \n");
		a.printSudoku();
		System.out.println(millis2-millis);
		a.printSudoku();
	}
	
	
	public boolean Solve(){
		for(int i = 0; i < sudoku.length; i++){
			for (int j = 0; j < sudoku.length; j ++){
				if(sudoku[i][j] == 0){
					for(int n = 1; n < (sudoku.length + 1); n++){
						if(check(n, i, j)){
							sudoku[i][j] = n;
							//System.out.println(n);
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
}
