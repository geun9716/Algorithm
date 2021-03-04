package Day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1922 {
	static int N, M, result = 0;
	static int [] p;
	static Computer [] edge;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		edge = new Computer [M];
		p = new int [N+1];
		
		for (int i = 0; i < M; i++) {
		
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c= sc.nextInt();
			
			edge[i] = new Computer(a, b, c);
			
		}
		//간선의 크기 순으로 정렬
		Arrays.sort(edge, new Comparator<Computer>(){
			@Override
			public int compare(Computer o1, Computer o2) {
				return Integer.compare(o1.c, o2.c);
			}
		});
		//크루스칼 알고리즘 사용 = 간선의 비용이 작은 것 부터 트리 구성
		//union- find 이용해서 트리 구성
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
//		System.out.println(Arrays.toString(p));
		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(p));
			//간선 정보를 읽어옴
			//둘이 연결되어 있는지 = 같은 그룹인지 확인
			if (find(edge[i].a) != find(edge[i].b)) {
				//서로 다른 그룹이면 연결, 비용도 추가
				
				union(edge[i].a, edge[i].b);

				//비용을 계산
				result += edge[i].c;
				
				//cnt++;
			}
		}
		//cnt != N-1 -> MST 구성이 안됨.
		System.out.println(result);
		sc.close();
	}
	static int find(int a) {
		if (a == p[a]) 
			return a;
		p[a] = find(p[a]);
		return p[a];
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		p[a] = b;
	}
	
}
class Computer{
	int a, b, c;

	public Computer(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}