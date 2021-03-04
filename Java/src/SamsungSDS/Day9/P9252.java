package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class P9252 {
	static char [] str1, str2;
	static int len1, len2, ans = 0;
	static int [][] dp;
	static Info [][] tracking;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		len1 = str1.length;
		len2 = str2.length;
		dp = new int [len1][len2];
		tracking = new Info[len1][len2];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		int result = calc(len1-1, len2-1);
		
		System.out.println(result);

		if (result != 0) {
			
			int p1 = len1-1;
			int p2 = len2-1;
			while(p1 >= 0 && p2 >= 0) {
				if(str1[p1] == str2[p2]) {
					stack.add(str1[p1]);
				}
				Info nxt = tracking[p1][p2];
				p1 = nxt.p1;
				p2 = nxt.p2;
			}
			
			while(!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		
//		for (int i = 0; i < tracking.length; i++) {
//			System.out.println(Arrays.toString(tracking[i]));
//		}
	}
	static int calc(int p1, int p2) {
		if(p1 < 0 || p2 < 0) return 0;
		//문자가 같으면
		if(dp[p1][p2] != -1)
			return dp[p1][p2];
		if(str1[p1] == str2[p2]) {
			dp[p1][p2] = calc(p1 - 1, p2 -1) + 1;
			tracking[p1][p2] = new Info(p1-1, p2-1);
			return dp[p1][p2];
		}
		//문자가 다르면
		int tmp1 = calc(p1-1, p2);	//str1의 끝 문자를 빼고 고려
		int tmp2 = calc(p1,p2-1);	//str2의 끝 문자를 빼고 고려
		
		if (tmp1 > tmp2) {
			dp[p1][p2] = tmp1;
			tracking[p1][p2] = new Info(p1-1, p2);
		} else {
			dp[p1][p2] = tmp2;
			tracking[p1][p2] = new Info(p1, p2-1);
		}
		
		return dp[p1][p2];
	}
}
class Info{
	int p1, p2;

	Info(int p1, int p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return "(" + p1 + ", " + p2 + ")";
	}
	
}
