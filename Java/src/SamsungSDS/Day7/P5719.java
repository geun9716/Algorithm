package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P5719 {
	static int N, M, INF = 10000001, S, D;
	static int [] dist;
	static boolean [][] used;
	static ArrayList<Edge> [] adj;
	static PriorityQueue<dijk_Info> pq;
	static Stack <Edge> [] stack;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			if(N == 0 && M == 0)
				break;

			pq = new PriorityQueue<>();
			adj = new ArrayList[N];
			stack = new Stack[N];
			used = new boolean[N][N];
			dist = new int [N];
			
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
				stack[i] = new Stack<>();
				dist[i] = INF;
			}
			
			S = sc.nextInt();
			dist[S] = 0;
			pq.add(new dijk_Info(S, dist[S]));
			D = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				adj[a].add(new Edge(a,b,c));
			}
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(adj[i]);
//			}		
			//최단 경로 구하기
			dijkstra();
//			System.out.println(Arrays.toString(dist));
//			System.out.println(Arrays.toString(stack));
			//최단 경로에 사용한 간선 제거하기
			
			rev_dfs(D);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(used[i]));
//			}	
			
			for (int i = 0; i < N; i++) {
				dist[i] = INF;
			}
			dist[S] = 0;
			pq.add(new dijk_Info(S, dist[S]));
			//거의 최단 경로 구하기
			dijkstra();
//			
//			System.out.println(Arrays.toString(dist));
//			System.out.println(Arrays.toString(stack));
			
			if(dist[D] == INF)
				System.out.println(-1);
			else
				System.out.println(dist[D]);
		}
	}
	static void dijkstra() {
		while(!pq.isEmpty()) {
			dijk_Info cur = pq.poll();
			
			for (int i = 0; i < adj[cur.node].size(); i++) {
				Edge nxt = adj[cur.node].get(i);
				if(used[nxt.a][nxt.b])
					continue;
				int tmp = cur.dist + nxt.c;
				
				if(tmp < dist[nxt.b]) {
					dist[nxt.b] = tmp;
					pq.add(new dijk_Info(nxt.b, dist[nxt.b]));
					stack[nxt.b].clear();
					stack[nxt.b].add(nxt);
				}
				else if (tmp == dist[nxt.b]) {
					pq.add(new dijk_Info(nxt.b, dist[nxt.b]));
					stack[nxt.b].add(nxt);
				}
			}
		}
	}
	
	static void rev_dfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int nxt = q.poll();
			if (nxt == S)
				break;
			while(!stack[nxt].isEmpty()) {
				Edge cur = stack[nxt].pop();
				//제거
				used[cur.a][cur.b] = true;
				q.add(cur.a);
			}
		}
	}

}
class Edge{
	int a, b, c;

	public Edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Edge [" + a + ", " + b + ", c=" + c + "]";
	}
	
}

//class dijk_Info implements Comparable<dijk_Info>{
//	int node, dist;
//
//	@Override
//	public String toString() {
//		return "dijk_Info [node=" + node + ", dist=" + dist + "]";
//	}
//
//	public dijk_Info(int node, int dist) {
//		this.node = node;
//		this.dist = dist;
//	}
//
//	@Override
//	public int compareTo(dijk_Info o) {
//		return Integer.compare(dist, o.dist);
//	}
//	
//}
