package Day4;

import java.util.Scanner;
import java.util.Stack;

public class GCD {
	static int N;
	static int left=0, right=1;
	static long [] num;
	static long [] gcdLtoR;
	static long [] gcdRtoL;
	static Stack <Long> stack = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		num = new long[N];
		gcdLtoR = new long[N];
		gcdRtoL = new long[N];
		for(int n=0; n < N; n++) {
			num[n] = sc.nextLong();
		}
		gcdLtoR[0] = num[0];
		gcdRtoL[N-1] = num[N-1];
		
		for(int i=1; i < N; i++) {
			gcdLtoR[i] = gcd(gcdLtoR[i-1], num[i]);
		}
		for(int i = N-2; i >= 0; i--) {
			gcdRtoL[i] = gcd(gcdRtoL[i+1], num[i]);
		}
		
		long max = 0;
		int maxIndex = 0;
		
		for(int i=0; i < N; i++) {
			long gcd = 0;
			if(i == 0) {
				gcd = gcdRtoL[1];
			} else if (i == N-1) {
				gcd = gcdRtoL[N-2];
			} else {
				gcd = gcd(gcdLtoR[i-1], gcdRtoL[i+1]);
			}
			if(num[i] % gcd != 0 && gcd > max) {
				max = gcd;
				maxIndex = i;
			}
		}
		if (max > 0)
			System.out.println(max +" "+ num[maxIndex]);
		else
			System.out.println("-1");
	}
	
	// gcd(a, b) == gcd(b, r) , r = a % b , r이 0이 되는 순간 탈출
	static long gcd(long a, long b) {
		while(b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return Math.abs(a);
	}
}
