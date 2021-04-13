import java.util.Scanner;

public class P2444 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = N-1; i > 0; i--) {
			for (int j = 0; j < N-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
