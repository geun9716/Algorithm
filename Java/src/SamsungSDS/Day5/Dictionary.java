package Day5;

import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
	static int N, M;
	static long R;
	static StringBuilder sb = new StringBuilder();
	static int [][] D;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextLong();

		
		D = new int [N+M+1][N+M+1];
		
		for(int n = 0; n <= N+M; n++) {
			for(int k = 0 ; k <= n; k++) {
				if( k == 0 || k == n) {
					D[n][k] = 1;
				}
				else {
					D[n][k] = (D[n-1][k-1] + D[n-1][k]);
					if (D[n][k] > R) {
						D[n][k] = (int)R;
					}
				}
			}
		}
		
//		for (int j = 0; j < D.length; j++) {
//			System.out.println(Arrays.toString(D[j]));
//		}
		int n = N+M;
		int k = N;
		if (D[n][k] < R) {
			System.out.println(-1);
			return;
		}
		search(n, k);
		sb.append('\n');
		System.out.println(sb.toString());
	}
	static void search(int n, int k) {
		if(R <= 0) {
			return ;
		}
		if (n > 0 && k > 0){
			if (D[n-1][k-1] >= R) {	// 위쪽 D[n-1][k-1]
				sb.append('a');
				N--;
				search(n-1, k-1);
			} else {				//	아래쪽 D [n-1][k]
				R -= D[n-1][k-1];
				sb.append('z');
				M--;
				search(n-1, k);
			}
		}
		else {
			for (int i = 0; i < N; i++) {
				sb.append('a');
			}
			for (int i = 0; i < M; i++) {
				sb.append('z');
			}
			return;
		}
	}
	
	public static int combination(int n , int k) {
		// n == 0, n == k
		if (n == 0 || n == k) {
			return 1;
		}
		else if (D[n][k] != 0) {
			return D[n][k];
		}
		else {
			return D[n][k] = combination(n-1, k-1) + combination(n-1, k);
		}
	}
}
