package Day6;

import java.util.ArrayList;
import java.util.Scanner;

public class P2458 {
	static int N, M, answer=0;
	static int visited_cnt, visited_rev;
	static boolean [] visited, re_visited;
	static ArrayList<Integer> [] adj;
	static ArrayList<Integer> [] rev;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		adj = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
		}
		
		while(M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a].add(b);
			rev[b].add(a);
		}
		
		
		for (int i = 1; i <= N; i++) {
			
			//나보다 큰 수를 셈
			visited_cnt = 0;	//나 + 나보다 큰 학생
			visited = new boolean [N+1];
			dfs(i);
			//나보다 작은 수를 셈
			visited_rev = 0;	 //나 + 나보다 작은 학생
			re_visited = new boolean [N+1];
			dfs_rev(i);
			
			if(visited_cnt + visited_rev == N+1) {
				answer++;
			}
		}
		System.out.println(answer);
		sc.close();
	}
	static void dfs(int cur) {
		if(visited[cur]) {
			return ;
		}
		visited[cur] = true;
		visited_cnt++;
		
		//Recursive
		for (int i = 0; i < adj[cur].size(); i++) {
			dfs(adj[cur].get(i));
		}
	}
	static void dfs_rev(int cur) {
		if(re_visited[cur]) {
			return ;
		}
		re_visited[cur] = true;
		visited_rev++;
		//Recursive
		for (int i = 0; i < rev[cur].size(); i++) {
			dfs_rev(rev[cur].get(i));
		}
	}
}
