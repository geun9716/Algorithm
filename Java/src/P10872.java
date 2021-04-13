import java.util.Scanner;

public class P10872 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println(factorial(N));
		sc.close();
	}
	static int factorial(int n) {
		if(n < 2)
			return 1;
		else
			return n * factorial(n-1);
	}

}
