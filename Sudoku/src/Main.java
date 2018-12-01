

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Main {
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Sudoku");
		frame.setSize(1000,1100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		SudokuSolve p1 = new SudokuSolve();
		frame.add(p1, BorderLayout.CENTER);
		
		p1.Solve();	
	
	}
}
