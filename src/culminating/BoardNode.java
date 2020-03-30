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

	public BoardNode(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;		
	}
	
	public void setPathLeft() {
		left = true;
	}
	
	public void setPathRight() {
		right = true;
	}
	
	public void setNoPath() {
		left = false;
		right = false;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0, 0, 0, 0));
		g.setColor(Color.BLACK);
		g.drawOval(xPos + border, yPos + border, size, size);
		if (left) {
			g.drawRect(xPos, yPos, 2, 32);
			g.drawRect(xPos, yPos, 15, 2);
		}
		if (right) {
			g.drawRect(xPos + 28, yPos, 2, 32);
			g.drawRect(xPos + 15, yPos, 15, 2);
		}
	}
}
