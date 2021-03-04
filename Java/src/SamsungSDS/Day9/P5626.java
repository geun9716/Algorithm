package Day9;

import java.util.Arrays;
import java.util.Scanner;

public class P5626 {
	static int N, MOD = 1000000007, max = 0;
	static int [] altar;
	static int [][] dp;
//	static int [][] new_dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		altar = new int [N+1];
		dp = new int[N+1][(N/2)+1];
//		new_dp = new int [2][(N/2)+1];
		for (int i = 1; i <= N; i++) {
			altar[i] = sc.nextInt();
			max = Math.max(altar[i], max);
		}
		
		if((altar[1] > 0 || altar[N] > 0) || max >= N/2) {
			System.out.println(0);
			return ;
		}
		
		// 양쪽 끝 비교 0이 아니면 -> 0
		// 가장 높은 높이 비교 -> 실패
		
		dp[1][0] = 1;
		//i번째 재단에서 가능한 높이 경우의 수를 넣는다
		for (int i = 2; i <= N; i++) {
			if(altar[i] != -1) {
				// j != altar[i] -> 계산 X
				int j = altar[i];
				if(j-1 >= 0) {
					dp[i][j] += dp[i-1][j-1];
					dp[i][j] %= MOD;
				}
				dp[i][j] += dp[i-1][j];
				dp[i][j] %= MOD;
				if(j+1 <= N/2) {
					dp[i][j] += dp[i-1][j+1];
					dp[i][j] %= MOD;
				}
			}
			else {
				for (int j = 0; j <= N/2 ; j++) {
					// else 계산 해야함.
					// j --> 이전의 높이가 j+1, j, j-1 합쳐지는 경우의 수
					if(j-1 >= 0) {
						dp[i][j] += dp[i-1][j-1];
						dp[i][j] %= MOD;
					}
					dp[i][j] += dp[i-1][j];
					dp[i][j] %= MOD;
					if(j+1 <= N/2) {
						dp[i][j] += dp[i-1][j+1];
						dp[i][j] %= MOD;
					}
//					dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1];
				}
			}
		}

//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(dp[N][0]);
	}

}
