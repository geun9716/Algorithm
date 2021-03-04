package Day8;

import java.util.Arrays;
import java.util.Scanner;

public class P1932 {
	static int N, ans;
	static int [][] tri, max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		tri = new int [N+1][N+1];
		max = new int [N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				tri[i][j] = sc.nextInt();
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(tri[i]));
//		}
	
		//init
		max[1][1] = tri[1][1];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				// max[i][j] == max[i-1][j], max[i-1][j-1];
				// j벗어나는지 처리를 해주면
				max[i][j] = Math.max(max[i-1][j], max[i-1][j-1]) + tri[i][j];
			}
		}
//
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(max[i]));
//		}

		
		for(int i = 1 ; i <= N ; i++) {
			ans = Math.max(max[N][i], ans);
		}
		System.out.println(ans);
	}

}
