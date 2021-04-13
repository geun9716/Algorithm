import java.util.Scanner;

public class P10870 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		System.out.println(fibonacci(N));
		
		
		sc.close();
	}
	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n <= 2) {
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
