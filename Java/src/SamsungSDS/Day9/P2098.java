package Day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2098 {
	static int N;
	static int [][] W; //i-j까지 이동거리
	static int [][] dp; //[i][j] 도시를 i처럼 거쳐왔고, 현재에 j있을때 이동한 거리
	static final int INF = 20000000;
	//dp[선택한 도시들][마지막에 여행한 도시]
	//w 비용
	//시작점으로 다시 와야 함
	//0번도시 1번도시 2번도시
	//0 0 0 0 0 0 0 1 1 0 0 0 0 0 : 6, 7 번도시만 선택함.
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		W = new int[N+1][N+1];
		dp = new int [(1<<N)][N];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < (1<<N); i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = INF;
			}
		}
		//시작점 세팅 : 0번째 도시에서 시작함... [0번째 도시를 거쳐왔고][현재 0번째에 있으니까]
		dp[1][0] = 0;
		for (int i = 0; i < (1<<N); i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (check_bit(i, k) == true)	//k로 갈 수 있는지
						continue;
					if (W[j][k] == 0)
						continue;
					int nxt = set_bit(i, k);
					dp[nxt][k] = Math.min(dp[nxt][k], dp[i][j] + W[j][k]);
				}
			}
		}
		
		
		//시작으로 가는 처리를 하면서 답을 구함
		int answer = INF;
		int last_state = (1<<N) - 1;
		//모든 도시를 순회했고, 비용을 구하면서 정답을 찾는다.
		for (int i = 0; i < N; i++) {
			if (W[i][0] == 0) continue;	//길이 없음.
			answer = Math.min(dp[last_state][i] + W[i][0],answer);
		}
		
		System.out.println(answer);
	}
	//pos 번째에 비트를 세팅함 : 가장 낮은 자리수가 0
	static int set_bit(int origin, int pos) {
		return origin | (1<<pos);
	}
	static int unset_bit(int origin, int pos) {
		return origin & ~(1<<pos);
	}
	static boolean check_bit(int origin, int pos) {
		if ((origin & (1<<pos)) == 0)
			return false;
		return true;
	}

}
