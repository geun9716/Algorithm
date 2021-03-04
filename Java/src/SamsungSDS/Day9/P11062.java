package Day9;

import java.util.Scanner;

public class P11062 {
	static int T, N;
	static int [] card, subsum;
	static int [][] gdp, mdp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			card = new int [N+1];
			subsum = new int [N+1];
			gdp = new int [N+1][N+1];
			mdp = new int [N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					gdp[i][j] = -1;
					mdp[i][j] = -1;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				card[i] = sc.nextInt();
				subsum[i] = subsum[i-1] +card[i];
			}
			
			System.out.println(g_play(1, N));
		}
	}
	
	static int g_play(int s, int e) {
		if (s == e) {
			return card[s];
		}
		if(gdp[s][e] != -1)
			return gdp[s][e];
		int left = 0, right = 0;
		//가장 왼쪽을 가져가거나
		//근우가 지금 가져가는 카드로 얻는 값 : card[s]
		//명우가 최선을 다해서 얻는 점수 : m_play(s+1, e)
		//근우가 나머지 플레이에서 얻는 점수 : [s+1 ~ e]까지의 합 = 명우가 최선을 다해서 얻는 점수
		left = card[s] + getSum(s+1, e) - m_play(s+1, e);
		//오른쪽을 가져가거나
		right = card[e] + getSum(s, e-1) - m_play(s, e-1);
		
		gdp[s][e] = Math.max(left, right);
		return gdp[s][e];
	}
	static int m_play(int s, int e) {
		if (s == e) {
			return card[s];
		}
		if(mdp[s][e] != -1)
			return mdp[s][e];
		int left = 0, right = 0;
		//가장 왼쪽을 가져가거나
		//근우가 지금 가져가는 카드로 얻는 값 : card[s]
		//명우가 최선을 다해서 얻는 점수 : m_play(s+1, e)
		//근우가 나머지 플레이에서 얻는 점수 : [s+1 ~ e]까지의 합 = 명우가 최선을 다해서 얻는 점수
		left = card[s] + getSum(s+1, e) - g_play(s+1, e);
		//오른쪽을 가져가거나
		right = card[e] + getSum(s, e-1) - g_play(s, e-1);
		
		mdp[s][e] = Math.max(left, right);
		return mdp[s][e];
	}
	static int getSum(int s, int e) {
		return subsum[e]-subsum[s-1];
	}
}
