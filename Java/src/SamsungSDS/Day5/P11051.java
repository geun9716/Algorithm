package Day5;

import java.util.Arrays;
import java.util.Scanner;

public class P11051 {
	static int N, K;
	static long [][] D;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		D = new long[N+1][N+1];
		
		
		// k==0 || k == n => 1
		//D[n][k] = D[n-1][k-1] + D[n-1][k];
		
		for(int n = 0; n <= N; n++) {
			for(int k = 0 ; k <= n; k++) {
				if( k == 0 || k == n) {
					D[n][k] = 1;
				}
				else {
					D[n][k] = (D[n-1][k-1] + D[n-1][k]) % 10007;
				}
			}
		}
		
//		for (int j = 0; j < D.length; j++) {
//			System.out.print(j);
//			System.out.println(Arrays.toString(D[j]));
//		}
		System.out.println(D[N][K]);
	}
}
