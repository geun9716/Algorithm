package Day8;

import java.awt.Point;
import java.util.Scanner;

public class P11049 {
	static int N, min = Integer.MAX_VALUE;
	static int [][] dp;
	static Point [] mat;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		mat = new Point[N+1];
		dp = new int [N+1][N+1];
		for (int i = 1; i <= N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			mat[i] = new Point(r, c);		
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
//		System.out.println(calc(1, N));
		
		solution2();
		System.out.println(dp[1][N]);
		
	}	
	//행렬의 s부터 e까지 계산을 해서 최적의 값을 내는 함수.
	static int calc(int s, int e) {
		if(e - s == 1) {
			return mat[s].x * mat[s].y * mat[e].y;
		}
		if(e == s) {
			return 0;
		}
		//적절한 처리를 해서 계산량을 줄일 예정임
		//calc(s,e)를 처음으로 계산한 적이 있으면, 그때 계산했던 결과를 사용함.
		// if...
		if(dp[s][e] != -1)
			return dp[s][e];
		//처음으로 계산을 하니까 일단 계산을 함
		// 부분으로 나눠서 괜찮은 값을 구한다.
		int mn= -1;
		for(int mid = s; mid < e ; mid++ ) {
			int tmp = calc(s,mid) + calc(mid+1,e) + mat[s].x * mat[mid].y * mat[e].y;
			if(mn == -1 || tmp < mn) mn = tmp;
		}
		//처음으로 계산 했기 때문에 계산 결과를 저장함.
		dp[s][e] = mn;
		return mn;
	}
	static void solution2() {
		int len;
		for (len = 2; len <= N; len++) {
			for (int s = 1; s+len-1 < N; s++) {
				int e = s + len - 1;
				int mn = -1;
				for (int mid = s; mid <= e-1; mid++) {
					int tmp = dp[s][mid] + dp[mid+1][e] + mat[s].x * mat[mid].y * mat[e].y;
					if(mn == -1 || tmp < mn) mn = tmp;
				}
				dp[s][e] = mn;
			}
		}
	}
}
