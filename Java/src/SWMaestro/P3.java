package SWMaestro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P3 {
	static int N, M, E;
	static int l, r;
	static int [] peanut;
	static nut [] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		E = sc.nextInt();
		list = new nut [N];
		for (int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			list[i] = new nut(tmp-E,Math.abs(tmp-E));
		}		
		
		Arrays.sort(list, new Comparator<nut>() {
			@Override
			public int compare(nut o1, nut o2) {
				return Integer.compare(o1.len, o2.len);
			}
		
		});
		
		for (int i = 0; i < M; i++) {
			if (list[i].pos >= 0) {
				r = list[i].len;
			}
			else {
				l = list[i].len;
			}
		}
		
		System.out.println(l+r);
		
		
		sc.close();
	}
}
class nut{
	int pos, len;

	public nut(int pos, int len) {
		this.pos = pos;
		this.len = len;
	}

	@Override
	public String toString() {
		return "nut [pos=" + pos + ", len=" + len + "]";
	}
}
/*
 6 3 7
 2 4 5 8 11 12


 */