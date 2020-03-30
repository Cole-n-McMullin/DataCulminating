package culminating;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EndingHolder extends JPanel{
	private int[] ballsRecieved;
	private int cols;
	private int rows;
	public EndingHolder(int rows) {
		this.rows = rows;
		cols = rows +1;
		ballsRecieved = new int[cols];
		for (int i = 0; i < ballsRecieved.length; i++) {
			ballsRecieved[i] = 0;
		}
	}

	public void addBall(int location) {
		ballsRecieved[location]++;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0, 0, 0, 0));
		g.setColor(Color.BLACK);

		g.drawLine(500-(30*cols/2), 170 + 30*cols, 500+(30*cols/2), 170 + 30*cols);
		for (int i = 0; i < rows; i++) { 
			g.drawString("" + ballsRecieved[i], (530-(30*cols/2)) + 30*i, 170 + 30*(cols));
		}
	}

}
