import java.util.Scanner;

public class P2581 {
	static int M, N;
	static int sum, min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		min = N;
		for (int i = M; i <= N; i++) {
			//소수판단
			int tmp = Prime(i);
			if(tmp > 0) {
				sum += tmp;
				min = Math.min(min, tmp);
			}
		}
		if(sum == 0) {
			System.out.println(-1);
			return ;
		}
		
		System.out.println(sum);
		System.out.println(min);
		
		sc.close();
	}
	static int Prime(int n) {
		if(n == 1) {
			return 0;
		}
		for(int i = 2; i < n; i++) {
			if(n%i == 0) {
				return 0;
			}
		}
		return n;
	}
}
