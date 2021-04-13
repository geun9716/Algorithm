import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
	static int N, M;
	static int [] mx = {1, -1, 0, 0};
	static int [] my = {0, 0, 1, -1};
	static boolean [][] isVisited;
	static char [][] map;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		isVisited = new boolean[N+1][M+1];
		map = new char [N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String tmp = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = tmp.charAt(j-1);
			}
		}
		
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		q.add(new Point(1,1));
		isVisited[1][1] = true;
//		while(!q.isEmpty()) {
			// 1. 큐에서 꺼내옴
			Point cur = q.poll();
			// 2. 목적지에 도달했는가?
			if (cur.x == N && cur.y == M) {
//				break;
			}
			// 3. 연결된 곳을 순회
			for (int i = 0; i < 4; i++) {
				int tx = cur.x + mx[i];
				int ty = cur.y + my[i];

				// 4. 갈 수 있는가?
				if(0 <= tx && tx < N && 0 <= ty && ty < M) {
					if(map[tx][ty] == '1'&& !isVisited[tx][ty]) {
						// 5. 체크인 & 큐에 넣음
						isVisited[tx][tx] = true;
						q.add(new Point(tx, ty));
					}
				}
			}
			System.out.println(q);
//		}
		
		for (int i = 0; i < isVisited.length; i++) {
			System.out.println(Arrays.toString(isVisited[i]));
		}
		
		
		
		
		
		sc.close();
	}
}
