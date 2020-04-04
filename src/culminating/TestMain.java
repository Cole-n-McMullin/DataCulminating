package culminating;

import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import javax.swing.JFrame;

public class TestMain {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many rows are on the Galtonboard? (cannot exceed 10)");
		int ans = Integer.valueOf(sc.nextLine());
		while(ans > 10) {
			System.out.println("(number of rows on the Galtonboard cannot exceed 10)");
			ans = Integer.valueOf(sc.nextLine());
		}
		GaltonBoard gb =  new GaltonBoard(ans +1);
		gb.paintComponents(gb.getGraphics());
		
		System.out.println("How many balls are you dropping? (cannot exceed 99999)");
		ans = Integer.valueOf(sc.nextLine());
		while(ans > 99999) {
			System.out.println("(number of dropped balls cannot exceed 99999)");
			ans = Integer.valueOf(sc.nextLine());
		}
		//drop balls through galtonboard
		for (int i = 0; i < ans; i++) {
			if (ans < 1000) {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			else if (ans < 5000) {
				TimeUnit.MILLISECONDS.sleep(10);
			}
			else {
				TimeUnit.MILLISECONDS.sleep(1);
			}
	    	gb.generatePath();			
		}
	}
}
