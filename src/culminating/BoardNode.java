package culminating;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BoardNode extends JPanel{
	
	private int xPos;
	private int yPos;
	private int border = 5;
	private int size = 20;
	
	public BoardNode(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0, 0, 0, 0));
		g.setColor(Color.BLACK);
		g.drawOval(xPos + border, yPos + border, size, size);
	}
}
