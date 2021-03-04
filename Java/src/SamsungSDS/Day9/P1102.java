package Day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1102 {
	static int N, P, INF = 10000;
	static int [][] W;
	static int [] dp;
	static boolean [] onoff;
	static char [] buf;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = new int [N][N];
		dp = new int [1<<N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		onoff = new boolean[N];
		buf = br.readLine().toCharArray();
		
		for (int i = 0; i < buf.length; i++) {
			if(buf[i] == 'Y')
				onoff[i] = true;
		}
		
		P = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < (1<<N); i++) {
			dp[i] = INF;
		}
		//최초 시작은 어떻게 진행해야 할까?
		//최초에 켜져있는 발전소르 아니까, 상태를 만들어서 그 상태의 dp[] = 0
		int first_state = 0;
		for (int i = 0; i < N; i++) {
			if(onoff[i]) {
				first_state = set_bit(first_state, i);
			}
		}
		
		dp[first_state] = 0;
		//시작
//		dp[state]
		for (int state = 0; state <= (1<<N) ; state++) {
			for (int i = 0; i < N; i++) {
				int nxt_state, nxt_cost;
				//state인 상태에서 i 발전소를 킬 수 있을까?
				if(check_bit(state, i)) { // state : 발전소가 켜져있는것, i가 있다는 것은 이미 켜져있는것
					continue;
				}
				//켜게되면 비용은 어떻게 될까?
				// 그때 state는 어떤 모양일까? : nxt_state
				nxt_state = set_bit(state, i);
				// nxt_state에는 어떤 값이 있었을까?
				for (int j = 0; j < N; j++) {	//	j번재 발전소를 이용해서 i를 키자
					if(check_bit(state, j)) {
						nxt_cost = dp[state] + W[j][i];
						if (nxt_cost < dp[nxt_state]) {
							dp[nxt_state] = nxt_cost;
						}
					}
				}
			}
		}
		int answer = INF;
		//Print : P를 고려하여 P보다 큰 것을 출력
		for (int i = 0; i < (1<<N); i++) {
			if(bitCount(i) >= P) {
				if (dp[i] < answer) {
					answer = dp[i];
				}
			}
		}
		if(answer == INF)
			answer = -1;
		
		System.out.println(answer);
	}
	static int bitCount(int x) {
		int cnt = 0;
		while(x > 0) {
			if ((x & 1) == 1) 
				cnt++;
			x /= 2;
		}
		return cnt;
	}
	static int set_bit(int origin, int pos) {
		return origin | (1<<pos);
	}
	static boolean check_bit(int origin, int pos) {
		if ((origin & (1<<pos)) == 0)
			return false;
		return true;
	}
	
	
}
