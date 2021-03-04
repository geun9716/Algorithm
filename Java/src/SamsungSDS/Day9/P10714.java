package Day9;

import java.util.Arrays;
import java.util.Scanner;

public class P10714 {
	static int N;
	static long result;
	static long [] cake;
	static long [][] dp; // [i][j] j군이 바라볼 때 왼쪽에는 i번째, 오른쪽에는 j번째  케이크, 많이 먹을 수 있는 케이크의 값
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cake = new long[N];
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			cake[i] = sc.nextLong();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			//i번재 케이크를 J군이 먹으면서 시작
			int nxtl, nxtr;
			nxtl = i+1;
			if(nxtl == N) 
				nxtl = 0;
			nxtr = i-1;
			if(nxtr < 0) 
				nxtr = N-1;
		
			result = Math.max(result, cake[i] + I_eat(nxtl, nxtr));
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dp[i]));	
//		}
		System.out.println(result);
	}
	// 먹을 차례가 되었는데 바라 볼때 왼쪽은 l케이크, 오른쪽은 r 케이크가 있을 때, 많이 먹는 값
	static long J_eat(int l, int r) {
		if (l == r)
			return cake[l];
		if (dp[l][r] != -1)
			return dp[l][r];
		int nxtl, nxtr;
		nxtl = l+1;
		if(nxtl == N) 
			nxtl = 0;
		nxtr = r-1;
		if(nxtr < 0) 
			nxtr = N-1;
				
		//l을 먹거나 //r을 먹거나
		//둘중 큰 값을 리턴
		dp[l][r] = Math.max(cake[l] + I_eat(nxtl, r), cake[r] + I_eat(l, nxtr));	
		return dp[l][r];
	}
	//I양이 먹을 차례가 되었는데 I양이 많이 먹을 수 있는 값
	//I양이 먹을 차례가 되었는데 J군이 많이 먹을 수 있는 값 -> 선택
	static long I_eat(int l ,int r) {
		if (l == r)
			return 0;
		if (dp[l][r] != -1)
			return dp[l][r];
		//먹을 수 있는 경우의 수는 없고 큰것만 먹어야함.
		if(cake[l] > cake[r]) {
			//cake[l]
			int nxtl = l+1;
			if(nxtl == N) 
				nxtl = 0;
			return J_eat(nxtl, r);
		}
		else {
			//cake[r]
			int nxtr = r-1;
			if(nxtr < 0) 
				nxtr = N-1;
			return J_eat(l, nxtr);
		}
	}

}
