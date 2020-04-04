package culminating;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EndingHolder extends JPanel{
	private int[] ballsRecieved;
	private int cols;
	private int rows;
	private int resized = 0;
	
	//creates the holder for the balls that have dropped through the galtonboard
	public EndingHolder(int rows) {
		this.rows = rows;
		cols = rows +1;
		ballsRecieved = new int[cols];
		for (int i = 0; i < ballsRecieved.length; i++) {
			ballsRecieved[i] = 0;
		}
	}
	
	//adds a ball to be added to the graph
	public void addBall(int location) {
		ballsRecieved[location]++;
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(new Color(0, 0, 0, 0));
		g.setColor(Color.BLACK);
		int height = 0;
		double scaling = 3;
		for (int i = 0; i < cols; i++) {
			if (ballsRecieved[i] > height) {
				height = ballsRecieved[i];
			}
		}
		//rescale as graph gets too big
		if (height > 50) {
			if (resized == 0) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 2;
		}
		if (height > 100) {
			if (resized == 1) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1;
		}
		if (height > 500) {
			if (resized == 2) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/2.0;
		}
		if (height >= 1000) {
			if (resized == 3) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/4.0;
		}
		if (height >= 2000) {
			if (resized == 4) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/8.0;
		}
		
		if (height >= 4000) {
			if (resized == 5) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/16.0;
		}
		if (height >= 8000) {
			if (resized == 6) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/16.0;
		}
		if (height >= 10000) {
			if (resized == 7) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/32.0;
		}
		if (height >= 16000) {
			if (resized == 8) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/64.0;
		}
		if (height >= 32000) {
			if (resized == 9) {
				g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 30 + (int) (scaling*height));
				resized++;
			}
			scaling = 1/128.0;
		}

		//draw rectangle to overwrite previous graph
		g.fillRect(500-(30*cols/2), (30*rows), 30*cols, 35 + (int) (scaling*height));
		g.setColor(Color.WHITE);
		//draw graph of where the balls have landed
		g.drawLine(500-(30*cols/2),(30*cols) + (int) (scaling*height), 500+(30*cols/2), (30*cols) + (int) (scaling*height));
		int[] x = new int[rows];
		int[] y = new int[rows];
		for (int i = 0; i < rows; i++) { 
			//g.drawdrawLine((530-(30*cols/2)) + 30*i, arg1, (530-(30*cols/2)) + 30*(i+1), arg3);
			x[i] = (530-(30*cols/2)) + 30*i;
			y[i] = 30*(cols) + (int)(scaling*(height-ballsRecieved[i]));
			if (i%2 == 0) {
				g.drawString("" + ballsRecieved[i], (525 -(30*cols/2)) + 30*i, 30*(cols) - 14);

			}
			else {
				g.drawString("" + ballsRecieved[i], (525-(30*cols/2)) + 30*i, 30*(cols));

			}
		}
		g.drawPolyline(x, y, rows);
	}

}
