package Day5;

import java.util.Arrays;
import java.util.Scanner;

public class P1010 {
	static int T, N, M;
	static long [][] D;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 0 ; t < T ; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			D = new long [M+1][M+1];
			
			for(int n = 0 ; n <= M ; n++) {
				for (int k = 0; k <= n; k++) {
					if(k == 0 || k == n) {
						D[n][k] = 1;
					}
					else {
						D[n][k] = D[n-1][k-1] + D[n-1][k]; 
					}
				}
			}
			System.out.println(D[M][N]);
		}
		sc.close();
	}
}
