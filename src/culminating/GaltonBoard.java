package culminating;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GaltonBoard extends JFrame {
	
	private BoardNode[][] nodes;
	private int rows;

	public GaltonBoard(int rows) {
		this.rows = rows;
		nodes = new BoardNode[rows][rows];
		
		for (int i = 1; i < rows; i++) {
			if (i/2 == 0) {
				nodes[i][i/2] = new BoardNode(485, 170 + i*30);
			}
			for( int j = 0; j < i/2; j++) {
				if (i % 2 == 0) {
					nodes[i][(i/2)+j] = new BoardNode(500 + j*30, 170 + i*30);
					nodes[i][(i/2)-(j+1)] = new BoardNode(500 - (j+1)*30, 170 + i*30);
				}
				else {
					if (j == 0) {
						nodes[i][i/2] = new BoardNode(485 + j*30, 170 + i*30);
					}
					nodes[i][(i/2)+(j+1)] = new BoardNode(485 + (j+1)*30, 170 + i*30);
					nodes[i][(i/2)-(j+1)] = new BoardNode(485 - (j+1)*30, 170 + i*30);
				}
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setVisible(true);
		
//		for (int i = 1; i < rows; i++) {
//			for( int j = 0; j < rows; j++) {
//				if (nodes[i][j]!=null) {
//					JPanel node = nodes[i][j];
//					add(node);
//					revalidate();
//				}
//			}
//		}
		
		for (int i = rows-1; i >= 1; i--) {
			for( int j = rows-1; j >= 0; j--) {
				if (nodes[i][j]!=null) {
					JPanel node = nodes[i][j];
					add(node);
					revalidate();
				}
			}
		}
	}
	
	public void generatePath() {
		int[] arr = new int[rows+1];
		Random rnd = new Random();
		int sum = 0;
		for (int j = 1; j < rows; j++) {
			int right = rnd.nextInt(2);
			sum += right;
			//left
			if (right == 0) {
				nodes[j][sum].setPathLeft();
			}
			//right
			if (right == 1) {
				nodes[j][sum-1].setPathRight();
			}
			//revalidate();

		}
		paintComponents(getGraphics());
		arr[sum]++;
		for (int i = 1; i < rows; i++) {
			for( int j = 0; j < rows; j++) {
				if (nodes[i][j]!=null) {
					nodes[i][j].setNoPath();
				}
			}
		}
		printArr(arr);
	}
//	
//	public static void printNodeLn(int numNodes, int curTotal, int right) {
//		// first row
//		System.out.print(" ");
//		for (int i = 0; i < numNodes; i++) {
//			System.out.print("  ");
//		}
//		System.out.println();
//		// second row
//		
//		for (int i = 0; i < 8-numNodes; i++) {
//			System.out.print(" ");
//		}
//		
//		if (curTotal == 0) {
//			System.out.print("|");
//		}
//		else {
//			System.out.print(" ");
//		}
//		for (int i = 0; i < numNodes; i++) {
//			if (right == 1) {
//				if (i == curTotal-1) {
//
//					System.out.print("0|");
//				} else {
//					System.out.print("0 ");
//				}
//			} 
//			else {
//				if (i == curTotal - 1) {
//
//					System.out.print("0|");
//				} else {
//					System.out.print("0 ");
//				}
//			}
//		}
//		System.out.println("   " + curTotal);
//	}
//
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public BoardNode[][] getNodes() {
		return nodes;
	}
	
	public int getRows() {
		return rows;
	}
	
//	protected void PaintComponent(Graphics g) {
//		super.paintComponent(g);
//		this.setBackground(new Color(0, 0, 0, 0));
//		for (int i = 1; i < rows; i++) {
//			for( int j = 0; j < i; j++) {
//				nodes[i][j].paintComponent(g);
//			}
//		}
//	}
	
}
