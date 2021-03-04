package Day9;

import java.util.Arrays;
import java.util.Scanner;

public class P7579 {
	static int N, M;
	static int [] mem, cost;
	static boolean [] used;
	static int [][] dp = new int [101][10001];	// [j][i] j까지 app을 대상으로 살펴봤을 때 cost i로 얻을 수 있는 최대 메모리 크기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		mem = new int [N+1];
		cost = new int [N+1];
		
		for (int i = 1; i <= N; i++) {
			mem[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}
		
		
		for (int j = 1; j <= N; j++) {
			for (int i = 0; i <= 10000; i++) {
				//[j][i] : j앱까지 고려했을때 cost i로 확보할 수 있는 최대 메모리
				// j번째 앱을 사용하거나 / 사용하지 않거나
				
				dp[j][i] = dp[j-1][i];	//j번째 앱을 사용하지 않았을 때,
				
				if (i - cost[j] >= 0) {	//j번째 앱을 사용 했을 때
					dp[j][i] = Math.max(dp[j-1][i-cost[j]] + mem[j], dp[j][i]);
				}
			}
		}
		
//		for (int i = 0; i <= 10; i++) {
//			//Cal
//			used = new boolean [N+1];
//			for (int j = 1; j <= N; j++) {
//				if (!used[j] && cost[j] <= i) {
//					System.out.println(i+" : "+j+" -> "+(dp[i-cost[j]] + mem[j]));
//					dp[i] = Math.max(dp[i-cost[j]] + mem[j], dp[i]);
//					used[j] = true;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(dp));
		
		//Print
		for (int i = 0; i <= 10000; i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				return ;
			}
		}
	}
}
