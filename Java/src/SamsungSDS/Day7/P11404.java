package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Floyd-Warchall Algorithm
 * 
 * */
public class P11404 {
	static int n, m, INF = 20000000;	//100개의 도시 10만 가중치
	static int [][] dist, adj;
//	static ArrayList<Info> [] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
//		adj = new ArrayList[n+1];
		adj = new int [n+1][n+1];
		dist = new int [n+1][n+1];		//i에서 j로 가는 비용
		
		//초기화
		for (int i = 1; i < dist.length; i++) {
			for (int j = 1; j < dist[i].length; j++) {
				if (i != j)
					dist[i][j] = INF;
			}
		}
		
//		for (int i = 1; i <= n; i++) {
//			adj[i] = new ArrayList<>();
//		}
		
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
//			adj[a].add(new Info(b, c));
			if(c < dist[a][b])
				dist[a][b] = c;	//최소값만 유지하기 위해서
		}
		
//		for (int i = 1; i < dist.length; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		
		floyd();
		//출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				if (dist[i][j] == INF)
					System.out.print(0+" ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void floyd() {
		for (int j = 1; j <= n; j++) {	//중간점
			for (int i = 1; i <= n; i++) {	//시작점
				for (int k = 1; k <= n; k++) {	//끝점
					if(dist[i][j] == INF || dist[j][k] == INF) continue;
					if(dist[i][j] + dist[j][k] < dist[i][k]) {		//INF를 더할 때, 오버플로우로 인해 음수가 나올 수도 있으므로 체크할 것.
						dist[i][k] = dist[i][j] + dist[j][k];
					}
				}
			}
		}
	}

}
//class Info{
//	int a, b, c;
//
//	public Info(int b, int c) {
//		this.a = a;
//		this.b = b;
//		this.c = c;
//	}
//}