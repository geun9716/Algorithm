package Day7;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P11400 {
	static int V, E, cnt = 0, num = 1;
	static int [] visit_order;
	static boolean [] visited;
	static boolean [] ans ;
	static Stack<Point> answer = new Stack<>();
	static ArrayList<Integer> [] adj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1];
		ans = new boolean[V+1];
		visit_order = new int [V+1];
		visited = new boolean[V+1];
		
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a].add(b);
			adj[b].add(a);
			
		}
		//단절점을 찾고
		for (int i = 1; i <= V; i++) {
			if(visit_order[i] == 0) {
				dfs(0, i, true);
			}
		}
		
		System.out.println(answer.size());
		//출력
		while(!answer.isEmpty()) {
			Point p = answer.pop();
			System.out.println(p.x +" "+p.y);
		}
		for (int i = 1; i <= V; i++) {
			if(ans[i])
				System.out.print(i+" ");
		}
	}
	//예외 : 루트일 경우
	//나의 방문순서와 자식들이 만나는 방문순서중 가장 작은 값을 비교
	static int dfs(int parent, int cur, boolean isRoot) {
//		if (visit_order[cur] != 0) {
//			return visit_order[cur];
//		}
		int clcnt = 0;
		visit_order[cur] = num;			//나의 번호
		int min_visit_order = num; //내 자식들이 만날 수 있는 점 중에서 가장 작은 점
		num++;
		
		for (int i = 0; i < adj[cur].size(); i++) {
			int nxt = adj[cur].get(i);
			if(nxt == parent) 
				continue;
			if(visit_order[nxt] > 0) {	//이전에 방문 했던 경우
				min_visit_order = Math.min(min_visit_order, visit_order[nxt]);
			}
			else {	// 새롭게 방문하는 경우
				int tmp = dfs(cur, nxt, false);
				min_visit_order = Math.min(tmp, min_visit_order);
				if (!isRoot && tmp >= visit_order[cur]) {
					//단절점
					ans[cur] = true;
					answer.push(new Point(cur, nxt));
				}
				clcnt++;
			}
		}
		//만약에 리프노드면, 단절점 처리를 해주지 않음.
		if (adj[cur].size() == 1) {
			return visit_order[cur];
		}
		
		if(isRoot) {
			//자식이 둘인지 체크
			//둘 이상이면 단절점
			if(clcnt >= 2) {
				ans[cur] = true;
			}
		}
		
		return Math.min(min_visit_order, visit_order[cur]);	//내가 만난 점중에서 방문순서가 가장 낮은 점을 반환함.
	}
}
