package SWMaestro2;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
	static int N, max = 0;
	static int [] arr, cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < N; i++) {
			cnt = new int [N];
			int index = i;
			while(true) {
				int nxt = index + arr[index];
				if(0 > nxt && N <= nxt) {
					break;
				}
				cnt[nxt]++;
				index = nxt;
				if(cnt[nxt] > 1000) {
//					System.out.println(Arrays.toString(cnt));
					int tmp = 0;
					for (int j = 0; j < cnt.length; j++) {
						if(cnt[j] >= 1000) {
							tmp++;
						}
					}
					max = Math.max(max, tmp);
					break;
				}
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}

}
/*
10
3 5 -1 -2 4 4 3 -2 -3 -2

3
*/