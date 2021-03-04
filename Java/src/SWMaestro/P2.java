package SWMaestro;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
	static int p, n, h;
	static int [] pc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		p = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		pc = new int [p+1];
		
		for (int i = 1; i < pc.length; i++) {
			pc[i] = h;
		}
		
		for (int i = 0; i < n; i++) {
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(y <= h) {
				pc[x] -= y;
			}
		}
		
		for (int i = 1; i < pc.length; i++) {
			if(pc[i] < 0) {
				pc[i] = 0;
			}
			System.out.println(i + " "+ (h-pc[i]) * 1000);
		}
		
		sc.close();
	}
}
/*
 2 7 4
1 10
1 5
1 7
2 10
2 1
2 3
2 7

1 0
2 4000

 */