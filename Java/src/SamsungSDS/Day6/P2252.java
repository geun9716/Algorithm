package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252 {
	static int N, M;
	static int [] indegree;
	static ArrayList<Integer> [] students;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		students = new ArrayList [N+1];
		indegree = new int [N+1];
		for (int i = 1; i < students.length; i++) {
			students[i] = new ArrayList<>();
		}
		
		while(M-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			students[a].add(b);
			indegree[b]++;
		}
		//indegree가 0인것을 찾는다.
		System.out.println(Arrays.toString(indegree));
		//어딘가 모아놓는다.
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		//모아 놓은 것을 하나씩 뽑으면서 출력하고
		while(!queue.isEmpty()) {
			System.out.println(queue);
			int current = queue.poll();
			System.out.println(current+" ");
			// 연결된 것들의 간선을 하나씩 줄여준다.
			for (int i = 0; i < students[current].size(); i++) {
				int next = students[current].get(i);
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		sc.close();
	}
}