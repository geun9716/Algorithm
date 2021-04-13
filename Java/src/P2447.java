import java.util.Scanner;

public class P2447 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		print(N);
		
		
		sc.close();
	}
	static void print(int n) {
		int cur = n/3;
		if (cur == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if((i / cur) == 1 && (j / cur) == 1) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if((i / cur) == 1 && (j / cur) == 1) {
						System.out.print(" ");
					} else {
						print(cur);
					}
				}
			}
		}
		System.out.println();
		
	}
}
