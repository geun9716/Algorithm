package Day4;

import java.util.Scanner;

public class P2960 {
	static int N, K, cnt=0;
	static boolean[] checked;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		checked = new boolean[N+1];
		
		for(int i = 2; i <= N ; i++) {
			if(!checked[i]) {
				checked[i] = true;
				cnt++;
				if(cnt >= K) {
					System.out.print(i);
					return ;
				}
//				System.out.print(i+" ");
				for (int j = i+i; j <= N; j+=i) {
					if(!checked[j]) {
//						System.out.print(j+" ");
						checked[j] = true;
						cnt++;
						if(cnt >= K) {
							System.out.print(j);
							return ;
						}
					}
				}
//				System.out.println(cnt);
			}
		}
		
	}

}
