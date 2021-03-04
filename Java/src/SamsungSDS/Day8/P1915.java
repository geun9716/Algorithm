package Day8;

import java.util.Arrays;
import java.util.Scanner;

public class P1915 {
	static int n, m, ans;
	static int [][] dp; // [i][j]를 오른쪽 아래로 했을 때 가장 큰 정사각형
	static int [][] mat;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		mat = new int[n+1][m+1];
		dp = new int [n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String tmp = sc.next();
			for (int j = 1; j <= m; j++) {
				mat[i][j] = tmp.charAt(j-1)-'0';
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(mat[i][j] == 0) {
					dp[i][j] = 0;
					continue;
				}
					
				//조사를 해야하는데 이웃한 곳들 : 좌, 상, 좌상
				//가장 작은 것
				int mn = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
				dp[i][j] = mn + 1;
				ans = Math.max(ans, dp[i][j]);
			}
		}
//		for (int i = 0; i <= n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(ans * ans);
	}

}
