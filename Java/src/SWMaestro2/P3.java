package SWMaestro2;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
	static int N, max;
	static int [][] soil;
	static boolean [][] checksoil;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		soil = new int[N+1][N+1];
		checksoil = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				soil[i][j] = sc.nextInt();
			}
		}
		
		//print
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(soil[i]));
		}
		
		
		dfs(1, N, 1, N, 0);
		
		System.out.println(max);
		
		sc.close();
	}
	static void dfs(int t, int d, int l, int r, int val){
		//체크인
		//목적지에 도달했는가?
		if(t == d && l == r) {
			max = Math.max(max, val);
			return ;
		}
		//연결된 곳을 순회
		int mid_td = (t + d) / 2;
		int mid_lr = (l + r) / 2;
		
		int tmp1 = max_soil(t, mid_td, l, r);
		int tmp2 = max_soil(mid_td+1, d, l, r);
		
		if (tmp1 >= tmp2) {
			dfs(t, mid_td, l, r, val + tmp1);
		}
		else {
			dfs(mid_td+1, d, l, r, val + tmp2);
		}
		
		
		int tmp3 = max_soil(t, d, l, mid_lr);
		int tmp4 = max_soil(t, d, mid_lr+1, r);
		if (tmp3 >= tmp4) {
			dfs(t, d, l, mid_lr, val + tmp3);
		} else {
			dfs(t, d, mid_lr+1, r, val + tmp4);
		}
		
		//갈 수 있는가?
		//간다
		//체크아웃
	}
	static int max_soil(int t, int d, int l, int r) {
		int result = 0;
		for (int i = t; i <= d; i++) {
			for (int j = l; j <= r; j++) {
				result = Math.max(result, soil[i][j]);
			}
		}
		return result;
	}
}

/*
 * 
4
1 3 4 5
6 2 9 9
4 3 10 5
5 2 8 6

34
*/