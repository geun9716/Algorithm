package SWMaestro;

import java.util.Scanner;

public class P4 {
	static int N, max;
	static int [] pan;
	static boolean [] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		pan = new int [N+1];
		
		
		for (int i = 1; i <= N; i++) {
			pan[i] = sc.nextInt();
		}
				
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			int cur, cnt = 0;
			cur = i;
			while(!visited[cur]) {
//				System.out.print(cur+"->");
				visited[cur] = true;
				cnt++;
				cur = cur + pan[cur];
			}
			cnt++;
//			System.out.println();
			max = Math.max(max, cnt);
//			System.out.println(cnt);
		}
		
		System.out.println(max);
		
		sc.close();
	}
}
