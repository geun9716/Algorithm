package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P11657 {
	static int n, m, INF = 10000000;
	static long [] dist;
	static boolean has_m_cycle = false;
	static ArrayList<Info> [] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		dist = new long[n+1];
		adj = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			dist[i] = INF;
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
		
			adj[a].add(new Info(b,c));
		}
		bell();
		
		//예외를 먼저 처맇마
		//시간이 무한히 되돌아가면 -1
		// 어떤 도시까지 가는 경로가 없으면 -1
		// 각 지점까지 거리 출력
		if (has_m_cycle) {
			System.out.println(-1);
		}
		else {
			//print
			for (int i = 2; i <= n; i++) {
				if (dist[i] == INF) 
					System.out.println(-1);
				else
					System.out.println(dist[i]);
			}
		}
	}
	static void bell() {
		//시작점 초기화
		dist[1] = 0;
		for (int i = 0; i < n-1; i++) {	//최대 방문할 수 있는 간선의 개수만큼 돌림 : n-1번
			for (int j = 1; j <= n; j++) { //j점 주변에 있는 점들을 업데이트 할 수 있는지 확임
				for (int k = 0; k < adj[j].size(); k++) {
					
					Info nxt = adj[j].get(k);
					if (dist[j] + nxt.c < dist[nxt.b]) {
						dist[nxt.b] = dist[j] + nxt.c;	//j를 nxt 이동하는 데 더 적은 비용으로 이동 가능하면 업데이트
					}
				}
//				System.out.println(Arrays.toString(dist));
			}
//			System.out.println(Arrays.toString(dist));
		}
		//전제 : n-1번 수행했기 때문에, 가장 먼 경로더라도 충분히 도달했을 것이다.
		//그리고 그 경로가 최단 경로 였을 것이다.
		//더 추가해서 방문을 했으면, 경로의 값이 커질테니까...
		//하지만 감소하는 구간이 존재했다면??
		for (int j = 1; j <= n; j++) { //j점 주변에 있는 점들을 업데이트 할 수 있는지 확임
			for (int k = 0; k < adj[j].size(); k++) {
				Info nxt = adj[j].get(k);
				if (Math.abs(dist[j] + nxt.c) < Math.abs(dist[nxt.b])) {
					//이런 일이 벌어질 수 있을까? 처리 필요?
					has_m_cycle = true;
				}
			}
		}
	}	
}	
//class Info{
//	int b;
//	long c;
//
//	public Info(int b, long c) {
//		this.b = b;
//		this.c = c;
//	}
//}