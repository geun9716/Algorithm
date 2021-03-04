package Day2;

import java.util.Scanner;

public class fibonaci2 {
	static int N;
	static long [] fi;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		fi = new long[N];
		
		for(int n=0; n < N ; n++) {
			if(n < 2) {
				fi[n] = 1;
			}
			else {
				fi[n] = fi[n-1]+fi[n-2];
			}
		}
		System.out.println(fi[N-1]);
	}
}
