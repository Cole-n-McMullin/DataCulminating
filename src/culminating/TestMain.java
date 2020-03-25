package culminating;

import java.util.Random;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for (int i = 1; i < 9; i++) {
		// printNodeLn(i);
		// }

		dropBalls();
		// Scanner sc = new Scanner(System.in);
		// //int input = sc.nextInt();
		// int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		// //for (int j = 0; j< input; j++) {
		// Random rnd = new Random();
		// int sum = 0;
		// for (int i= 0; i < 8; i++) {
		// sum += rnd.nextInt(2);
		// }
		// arr[sum]++;
		// //}
		// printArr(arr);
	}

	public static void dropBalls() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int j = 0; j < input; j++) {
			Random rnd = new Random();
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				int right = rnd.nextInt(2);
				sum += right;
				printNodeLn(i, sum, right);
//				sum += right;
			}
//			System.out.println(sum);
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

}
