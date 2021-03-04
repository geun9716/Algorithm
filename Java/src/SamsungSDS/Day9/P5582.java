package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5582 {
	static char [] str1, str2;
	static int len1, len2, ans = 0;
	static int [][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		len1 = str1.length;
		len2 = str2.length;
		dp = new int [len1][len2];
		

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < len1 ; i++) {
			for (int j = 0; j < len2; j++) {
				ans = Math.max(cal2(i,j), ans);
			}
		}
		System.out.println(ans);
	}
	//p1, p2로 끝나는 문자열의 lcs
	static int calc(int p1, int p2) {
		if(p1 < 0 || p2 < 0) {
			return 0;
		}
		if(str1[p1] == str2[p2]) {
			return calc(p1-1, p2-1) + 1;
		}
		else
		{
			return 0;
		}
	}
	static int cal2(int p1, int p2) {
		if(p1 < 0 || p2 < 0) {
			return 0;
		}
		if(dp[p1][p2] != -1) {
			return dp[p1][p2];
		}
		if(str1[p1] == str2[p2]) {
			dp[p1][p2] = cal2(p1-1, p2-1) + 1;
			return dp[p1][p2];
		}
		else
		{
			dp[p1][p2] = 0;
			return dp[p1][p2];
		}
	}
}
