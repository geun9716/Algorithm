import java.util.Scanner;

public class P2775 {
	static int T, k, n;
	static int [][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		while(T-- > 0) {
			k = sc.nextInt();
			n = sc.nextInt();
			// 1  4 10 20 35
			// 1  3  6 10 15
			// 1  2  3  4  5
			dp = new int [k+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				dp[0][i] = i; 
			}
			
			int result = dfs(k, n);
			
			System.out.println(result);
			
		}
		
		sc.close();
	}
	static int dfs(int a, int b) {
		if(a == 0)
			return b;
		else if(b == 1)
			return 1;
		
		return dfs(a, b-1) + dfs(a-1, b);
		
		
	}

}
