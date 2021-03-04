package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P3860 {
	static int [] dx = {1, -1, 0, 0};
	static int [] dy = {0, 0, 1, -1};
	
	static int W, H, G, INF = 100000, cnt=0;
	static boolean has_cycle = false;
	static List<hole> [][] adj;
	static int [][] map, dist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			W = sc.nextInt();
			H = sc.nextInt();
			
			if (W == 0 && H == 0)
				break;
			//초기화
			map = new int [W][H];
			dist = new int [W][H];
			adj = new ArrayList[W][H];
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					adj[i][j] = new ArrayList<>();
					if(!(i == 0 && j == 0 || i == W-1 && j == H-1))
						map[i][j] = 1;
				}
			}
			
			
			//묘지 세팅
			G = sc.nextInt();
			for (int i = 0; i < G; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[X][Y] = INF;				
			}
			
			for (int i = 0; i < W; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			int E = sc.nextInt();
			
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int X1 = Integer.parseInt(st.nextToken());
				int X2 = Integer.parseInt(st.nextToken());
			
				int Y1 = Integer.parseInt(st.nextToken());
				int Y2 = Integer.parseInt(st.nextToken());
			
				int T = Integer.parseInt(st.nextToken());
				
				adj[X1][X2].add(new hole(Y1, Y2, T));
			}
			
			//bell-man
			bell();
			
			
			if (has_cycle) {
				System.out.println("Never");
			} else {
				if(dist[W-1][H-1] == INF)
					System.out.println("Impossible");
				else
					System.out.println(cnt);
			}
		}
		sc.close();
	}
	static void bell(){
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				
			}
		}
	}
}
class hole{
	int x, y, t;

	public hole(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
	
}
