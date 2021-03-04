package SWMaestro;

import java.util.Scanner;

public class P6 {
	static int N, result;
	static int [] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new int [N+1];
		
		for (int i = 1; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		int l = 1;
		int r = N;
		while(l != r) {
			int mid = (l+r) / 2;
			
			int lmax = MAX(l, mid);
			int rmax = MAX(mid+1, r);
			
			if(lmax >= rmax) {
				result += lmax;
				l = mid+1;
			}
			else {
				result += rmax;
				r = mid;
			}
			
		}
		
		System.out.println(result);
		sc.close();
	}
	public static int MAX(int l, int r) {
		if(l == r) {
			return list[l];
		}
		int max = 0;
		for (int i = l; i < r; i++) {
			max = Math.max(max, list[i]);
		}
		return max;
	}
}
/*
 * 8
1 3 10 9 6 2 3 2

19
*/
