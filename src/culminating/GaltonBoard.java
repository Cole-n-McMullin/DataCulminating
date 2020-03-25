package culminating;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GaltonBoard extends JPanel {
	
	private BoardNode[][] nodes;
	private int rows;
	public GaltonBoard(int rows) {
		this.rows = rows;
		nodes = new BoardNode[rows][rows];
		for (int i = 1; i < rows; i++) {
			for( int j = 0; j < i/2; j++) {
				if (i % 2 == 0) {
					nodes[i][(i/2)+j] = new BoardNode(500 + j*30, 170 + i*30);
					nodes[i][(i/2)-(j+1)] = new BoardNode(500 - (j+1)*30, 170 + i*30);
				}
				else {
					if (j == 0) {
						nodes[i][i/2] = new BoardNode(515 + j*30, 170 + i*30);
					}
					nodes[i][(i/2)+(j+1)] = new BoardNode(515 + (j+1)*30, 170 + i*30);
					nodes[i][(i/2)-(j+1)] = new BoardNode(515 - (j+1)*30, 170 + i*30);
				}
			}
		}		
	}
	
	public void generatePath() {
		int[] arr = new int[rows+1];
		for (int j = 0; j < rows; j++) {
			Random rnd = new Random();
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				int right = rnd.nextInt(2);
				sum += right;
				printNodeLn(i, sum, right);
			}
			arr[sum]++;
		}
		printArr(arr);
	}
	
	public static void printNodeLn(int numNodes, int curTotal, int right) {
		// first row
		System.out.print(" ");
		for (int i = 0; i < numNodes; i++) {
			System.out.print("  ");
		}
		System.out.println();
		// second row
		
		for (int i = 0; i < 8-numNodes; i++) {
			System.out.print(" ");
		}
		
		if (curTotal == 0) {
			System.out.print("|");
		}
		else {
			System.out.print(" ");
		}
		for (int i = 0; i < numNodes; i++) {
			if (right == 1) {
				if (i == curTotal-1) {

					System.out.print("0|");
				} else {
					System.out.print("0 ");
				}
			} 
			else {
				if (i == curTotal - 1) {

					System.out.print("0|");
				} else {
					System.out.print("0 ");
				}
			}
		}
		System.out.println("   " + curTotal);
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	protected void PaintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0, 0, 0, 0));
		for (int i = 1; i < rows; i++) {
			for( int j = 0; j < i; j++) {
				nodes[i][j].paintComponent(g);
			}
		}
	}
	
}
