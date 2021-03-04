package Day2;

import java.util.Scanner;

public class goDown {
	static int N;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int [N+1][3];
		
		for(int i=0; i < N; i++) {
			for(int j=0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		
	}

}
