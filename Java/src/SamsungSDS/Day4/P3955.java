package Day4;

import java.util.Arrays;
import java.util.Scanner;

public class P3955 {
	static int T;
	static long A, B;
	
	public static void main(String[] args) {
		// X : 인당 나눠줄 사탕의 수
		// Y : 사탕 봉지의 수
		// A * X + 1 = B * Y   =>    A(-x) + By = 1 
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t=0; t < T ; t++) {
			//A, B 입력
			A = sc.nextLong();
			B = sc.nextLong();
			
			//D = gcd(A, B)
			//D * k = C ==> C % D == 0 : 베주 항등식
			//확장 유클리드 호제법을 이용하여 s, t, r = D을 찾아냄.
			long [] str = eGcd(A, B);
			long D = str[2];

//			System.out.println(Arrays.toString(str));
			if(1 % D != 0) {
				System.out.println("IMPOSSIBLE");
				continue;
			}
			// x0 = s * (C/D)
			// y0 = t * (C/D)
			long x0 = str[0];		//C =1, D = 1
			long y0 = str[1];
//			System.out.println(x0+", "+ y0);
			//일반 해 공식 (k 는 일반해에서 나오는 k)
			// x = x0 + B/D * k
			// y = y0 - A/D * k
			
			// x < 0 -> 방정식의 형태를 맞춰주기위해 부호를 바꾸었기 때문에 
			// x0 + B/D*k < 0
			// k < - x0 / B * D
			
			// 0 < y <= 10^9 (1e9)
			// 0 < y0 - A/D*k <= 1e9
			// -y0 < - A/D * k <= 1e9 - y0
			
			// (D/A) * (y0 - 1e9) <= k < y0 * (D/A)
			// 						k < - x0 / B*D
			long k1 = (long)Math.ceil((double)-x0 * D / B)-1;
			long k2 = (long)Math.ceil((double)y0 * D / A)-1;
//			System.out.println(k1+", "+k2);
			// k1과 k2가 범위의 최대 값이므로 둘을 만족하려면 min으로 k의 max값을 구해내야 한다.
			// k의 max를 구한 후 그 k를 이용해서 y값을 구해냅니다. => k가 커지면 y가 작아지므로
			
			long k = (long)Math.min(k1, k2);
			long y = y0 - A/D * k;
			if (y <= 1e9) {
				System.out.println(y);
			}
			else
				System.out.println("IMPOSSIBLE");
			// 그렇게 구한 y는 가장 작은 y값이다.
			// 그 y값이 1e9 보다 작거나 같으면 가능한 답.
			// 아니면 불가능한 답.
		}
		
		sc.close();
	}

	// ax + by = c => as + bt = r을 만족하는 s, t, r 조합을 찾기 (r이 gcd(a,b)일때)
	static long[] eGcd(long a, long b) {
		long s0 = 1, t0 = 0, r0 = a;
		long s1 = 0, t1 = 1, r1 = b;
		
		long temp;
		while(r1 != 0) {
			long q = r0 / r1;
			
			temp = r0 - q * r1; // => 새로운 r 값
			r0 = r1;
			r1 = temp;
			
			temp = s0 - q * s1;
			s0 = s1;
			s1 = temp;
			
			temp = t0 - q * t1;
			t0 = t1;
			t1 = temp;
		}
		
		return new long[] {s0, t0, r0};
	}
}
