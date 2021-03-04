package Day1;
import java.util.*;

public class Escape {
	
	static int[] mx = {-1, 1 ,0 ,0};
	static int[] my = {0, 0, -1, 1};
	
	static int R, C;
	static char [][] map;
	static int [][] dp;
	static boolean foundAnswer;
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		Point st = null;
		map = new char[R][C];
		dp = new int[R][C];
		
		for(int r=0; r < R; r++) {
			String line = sc.next();
			for (int c = 0 ; c < C; c++) {
				map[r][c] = line.charAt(c);
				if (map[r][c] == '*') {
					queue.add(new Point(r, c, '*'));
				} else if (map[r][c] == 'S') {
					st = new Point(r, c, 'S');
				}
			}
		}
		
		queue.add(st);
		
		while(!queue.isEmpty()) {
			//1. 큐에서 꺼내옴
			Point p = queue.poll();
			//2. 목적지인가? if(p == D)
			if (p.type == 'D') {
				System.out.println(dp[p.x][p.y]);
				foundAnswer = true;
				return;
			}
			//3. 갈수 있는 곳을 순회 for(좌, 우, 위 , 아래)
			for(int i = 0 ; i < 4; i++) {
				int tx = p.x+mx[i];
				int ty = p.y+my[i];
				//4. 갈수 있는가? if (맵을 벗어나지 않고, X가 아니고, *아니고)
				if ((0 <= tx && tx < R) && (0 <= ty && ty < C)) {
					if (p.type == 'S' || p.type == '.') {	//고슴도치
						if (dp[tx][ty] == 0 && (map[tx][ty] == 'D' || map[tx][ty] == '.')) {
							//5. 체크인 dp[r][c] = time
							dp[tx][ty] = dp[p.x][p.y] + 1 ;
							//6. 큐에 넣음 queue.add(next)
							queue.add(new Point(tx, ty, map[tx][ty]));
						}
					} else {
						if (map[tx][ty] == '.') {
							map[tx][ty] = '*';
							queue.add(new Point(tx, ty, '*'));
						}
					}
				}
			}
		}
		
		if (foundAnswer == false) {
			System.out.println("KAKTUS");
		}
		sc.close();
	}
}
class Point{
	int x;
	int y;
	char type;
	public Point(int x, int y, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+x+","+y+"]";
	}
}
