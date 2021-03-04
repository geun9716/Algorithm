package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P11438 {
	static int N, M;
	static int [] depths;
	static boolean [] visited;
	static int [][] ans;
	static ArrayList<Integer> [] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		adj = new ArrayList[N+1];
		depths = new int[N+1];
		ans = new int[N+1][18];	// 2^0 2^1 .... 2^17번째 조상을 담음
		visited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		System.out.println(Arrays.toString(adj));
		
		//LCA를 위한 자료 수집 : 깊이, 1/2/4 ... , dfs
		dfs(1, 1, 1);
		System.out.println(Arrays.toString(depths));
		// 2^1 2^2, 2^3... 조상
		for (int i = 1; i <=17 ; i++) {	//2^ i번째 조상
			for (int j = 1; j <= N ; j++) {	//1번 노드, 2번노드... n번 노드
				ans[j][i] = ans[ans[j][i-1]][i-1]; // i-1번째의 i-1번째 조상이 i번째 조상이 된다. sparse table
			}
		}
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(ans));
		}
		M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(lca(a, b));
		}
		
		sc.close();
	}
	
	static void dfs(int parent, int current, int depth) {
		if(visited[current])	
			return ;
		visited[current] = true;
		depths[current] = depth;
		ans[current][0] = parent;
		for (int i = 0; i < adj[current].size(); i++) {
			dfs(current, adj[current].get(i), depth + 1);
		}
	}
	
	static int lca(int a, int b) {
		//만약에 깊이가 서로 다르면 맞춰준다...
		//a의 깊이가 b보다 더 깊게 만들어서 처리하기 쉽게 함.
		if(depths[a] < depths[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		if(depths[a] != depths[b]) {
			// a --> b까지 깊이를 맞춘다.
			int diff = depths[a] - depths[b];
			//diff = 13 = 8+4+1
			
			for (int i = 0, j = 1; i <= N; i++, j*=2) {
//				if(diff & (i<<i))
				if((diff & j) == 0) {
					a = ans[a][i];
				}
			}
		}
		
		//depths[a] == depths[b] 인 상태
		if(a == b) //a를 올렸더니 b가 a의 조상인 경우
			return a;
		
		for(int i = 17; i >= 0; i--) {
			if(ans[a][i] != ans[b][i]) {
				a = ans[a][i];
				b = ans[b][i];
			}
		}
		// LCA의 바로 아래까지 옴.
		return ans[a][0];
	}
}
