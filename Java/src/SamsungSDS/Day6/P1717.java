package Day6;

import java.util.Arrays;
import java.util.Scanner;

public class P1717 {
	static int N, M;
	static int [] p;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int [N+1];
		
		for (int i = 0; i <=N; i++) {
			p[i] = i;
		}
		
		for (int m = 0; m < M; m++) {
			int cmd, a, b;
			cmd = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
			if (cmd == 0) {
				//to do union
				unionf(a, b);
			}
			else if (cmd == 1) {
				//to do find, print yes or no
				int tmp = findf(a) - findf(b);
				if (tmp == 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
//			System.out.println(Arrays.toString(p));
		}
		sc.close();
	}
	//a의 부모가 누군지 알려줌.
	static int findf(int a) {
		if(a == p[a])
			return a;
//		return findf(p[a]); //재귀적 시간초과
		p[a] = findf(p[a]);	//
		return p[a];	
	}
	// a 와 b 를 합침
	static void unionf(int a, int b) {
		a = findf(a);
		b = findf(b);
		p[a] = b;
	}
}

