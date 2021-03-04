package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {
	static StringTokenizer st;
	static int n;
	static int [] build_time, answer, indegree, before_max;
	static ArrayList<Integer> adj[];
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		build_time = new int [n+1];
		answer = new int [n+1];
		indegree = new int [n+1];
		before_max = new int [n+1];
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i =1 ; i <=n; i++) {
			st = new StringTokenizer(br.readLine());
			build_time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) break;
				adj[a].add(i);
				indegree[i]++;
			}
		}
		
		//위상정렬을 통해서 , 시작점 = 들어오는 간선이 없는 것들
		for(int i = 1; i<=n ;i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		//각각의 건물이 지어지는 최소 시간.. -> answer
		while(!q.isEmpty()) {
			int cur = q.poll();
			//cur를 처리함. 이미 before_max는 어떤 값이 잘 들어 있다고 생각할 수 있음.
			answer[cur] = before_max[cur] + build_time[cur];
			// 다음 건물 처리 간선을 하나 빼주고 && 그 건물이 지어지기 전에 가장 큰 값 (before_max) 값 수정
			for (int i = 0; i < adj[cur].size(); i++) {
				int nxt = adj[cur].get(i);
				--indegree[nxt]; // 간선 하나 뺴줌.
				if(before_max[nxt] < answer[cur]) {
					before_max[nxt] = answer[cur];
				}
				if(indegree[nxt] == 0)
					q.add(nxt);
			}
		}
		
		//print
		for(int i = 1 ; i <=n ;i++) {
			System.out.println(answer[i]);
		}
	}

}
