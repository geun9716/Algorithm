import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2606 {
	static int N, M, cnt=0;
	static ArrayList<Integer> [] com;
	static boolean [] isInfected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		isInfected = new boolean[N+1];
		com = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			com[i] = new ArrayList<>();
		}
		
		M = sc.nextInt();
		
		while (M-- > 0 ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			com[x].add(y);
			com[y].add(x);
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(i + " : "+com[i]);
//		}
		
		dfs(1);
//		System.out.println(Arrays.toString(isInfected));
		for (int i = 2; i < isInfected.length; i++) {
			if(isInfected[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
	static void dfs(int num) {
		//1. 체크인
		isInfected[num] = true;
		//2. 목적지에 도착했는가?
		
		//3. 연결된 곳을 순회
		for(int nxt : com[num]) {
			//4. 갈 수 있는가?
			if(isInfected[nxt] == false) {
				//5. 간다.
				dfs(nxt);
			}
		}
		//6. 체크아웃
	}

}
