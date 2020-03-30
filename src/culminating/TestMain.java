package culminating;

import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class TestMain {

	public static void main(String[] args) {
		GaltonBoard gb =  new GaltonBoard(8);
		gb.paintComponents(gb.getGraphics());
		System.out.println("How many balls areyou dropping?");
		Scanner sc = new Scanner(System.in);
		int ans = Integer.valueOf(sc.nextLine());
		for (int i = 0; i < ans; i++) {
			gb.generatePath();
		}
	}
}
