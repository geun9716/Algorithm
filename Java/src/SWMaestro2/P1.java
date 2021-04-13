package SWMaestro2;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class P1 {
	static int t, M, N;
	static Point start, key, box;
	static int [] tx = {1, -1 , 0, 0};
	static int [] ty = {0, 0, 1, -1};
	static int [][] map;
	static boolean [][] isVisited;
	static boolean goKey, goBox;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t-- > 0) {
			
			M = sc.nextInt();
			N = sc.nextInt();
			
			isVisited = new boolean[M+1][N+1];
			map = new int [M+1][N+1];
			//input
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						box = new Point(i, j);
					}
					else if (map[i][j] == 3) {
						start = new Point(i, j);
					}
					else if (map[i][j] == 4) {
						key = new Point(i, j);
					}
				}
			}
			//map print
//			for (int i = 0; i < M; i++) {
//				System.out.println(Arrays.toString(map[i]));	
//			}
			
			goKey = false;
			goBox = false;
			dfs(start);
			
			if(goKey && goBox) {
				System.out.println(1);
			}
			else
				System.out.println(0);
		}
		
		sc.close();
	}
	static void dfs(Point cur) {
		// 체크인
		isVisited[cur.x][cur.y] = true;
//		System.out.println(cur);
		// 목적지에 도착했는가
		if (cur.equals(box)) {
//			System.out.println("is Box");
			goBox = true;
			return ;
		} else if (cur.equals(key)) {
//			System.out.println("is Key");
			goKey = true;
			return ;
		}
		// 연결된 곳을 순회
		for (int i = 0; i < 4; i++) {
			int mx = cur.x + tx[i];
			int my = cur.y + ty[i];
			// 갈 수 있는가?
			if((0 <= mx && mx < M) && (0 <= my && my < N)) {
				if(map[mx][my] != 1 && !isVisited[mx][my]) {
					// 간다
					dfs(new Point(mx, my));
				}
			}
		}
		// 체크아웃
		isVisited[cur.x][cur.y] = false;
	}
}

/*
 * 
2
5 6
0 0 1 0 2 0
1 0 1 0 0 0
0 0 1 1 1 0
0 3 0 1 0 0
4 0 0 0 0 0
5 6
0 0 1 0 2 0
1 0 1 0 0 0
0 0 1 1 1 0
0 3 0 1 0 0
4 0 0 1 0 0
1
0
 * 
*/
