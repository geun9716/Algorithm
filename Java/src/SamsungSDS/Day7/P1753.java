package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// INF 300000

public class P1753 {
	static int V, E, K, INF = 20001*10;;
	static int [] dist;
	static ArrayList<Info> [] adj;
	static PriorityQueue<dijk_Info> pq = new PriorityQueue<>();
//	static PriorityQueue<dijk_Info> pq2 = new PriorityQueue<>(new Comparator<dijk_Info>(){
//		@Override
//		public int compare(dijk_Info o1, dijk_Info o2) {
//			// TODO Auto-generated method stub
//			return o1.dist-o2.dist;
//		}
//	});
//	static int [][] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1];
		dist = new int [V+1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		K = sc.nextInt();
		
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			adj[a].add(new Info(b,c));
		}
		for (int i = 1; i <= V; i++) {
			dist[i] = INF;
		}
		//dijkstra
		
		//시작점 거리 셋팅
		dist[K] = 0;
		pq.add(new dijk_Info(K, dist[K]));
		while(!pq.isEmpty()) {
			dijk_Info cur = pq.poll();
			
			//current dist가 저장된 dist보다 큰 경우 불필요한 계산 방지
			if(dist[cur.node] < cur.dist) continue;
			
			//cur의 주변을 탐색한다.
//			System.out.println(cur);
//			System.out.println(Arrays.toString(dist));
			for (int i = 0; i < adj[cur.node].size(); i++) {
				Info nxt = adj[cur.node].get(i);
//				dist[nxt.b] = cur.dist + nxt.c;	//cur -> nxt로 이동할때 드는 비용
				int tmp = cur.dist + nxt.c;	//cur -> nxt로 이동할때 드는 비용
				if (tmp < dist[nxt.b]) {
					dist[nxt.b] = tmp;
					pq.add(new dijk_Info(nxt.b, tmp));
				}
			}
		}
		
		//print
		for (int i = 1; i <= V; i++) {
			if(dist[i] != INF) {
				System.out.println(dist[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}

}
class Info{
	int b, c;

	public Info(int b, int c) {
		this.b = b;
		this.c = c;
	}
}
class dijk_Info implements Comparable<dijk_Info>{
	int node, dist;

	@Override
	public String toString() {
		return "dijk_Info [node=" + node + ", dist=" + dist + "]";
	}

	public dijk_Info(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(dijk_Info o) {
		return Integer.compare(dist, o.dist);
	}
	
}