package culminating;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BoardNode extends JPanel{
	
	private int xPos;
	private int yPos;
	private int border = 5;
	private int size = 20;
	private boolean left = false;
	private boolean right = false;

	//creates a new galtonboard pin
	public BoardNode(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;		
	}
	
	//sets the path left of the pin
	public void setPathLeft() {
		left = true;
	}
	
	//sets the path left of the pin
	public void setPathRight() {
		right = true;
	}
	
	//removes the path from the pin
	public void setNoPath() {
		left = false;
		right = false;
	}
	
	//paints the galtonboard pin
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0, 0, 0, 0));
		g.setColor(Color.BLACK);
		g.fillOval(xPos + border, yPos + border, size, size);
		if (left) {
			g.fillRect(xPos, yPos, 2, 32);
			g.fillRect(xPos, yPos, 15, 2);
		}
		if (right) {
			g.fillRect(xPos + 28, yPos, 2, 32);
			g.fillRect(xPos + 15, yPos, 15, 2);
		}
	}
}
