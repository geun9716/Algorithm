package Day2;

import java.util.Scanner;

public class Game {
	static long X, Y, Z;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		X = sc.nextLong();
		Y = sc.nextLong();
		Z = 100 * Y / X;
		
		long s = 0;
		long e = 1000000000+1;
		// 99 -> 100%
		if (Z >= 99) {
			System.out.println(-1);
		}
		else {
			long result = -1;
			long mid = 0;
			long rate = 0;
			while(s < e) {
				mid = (s+e)/2;
				rate = 100 * (Y+mid) / (X+mid);
				System.out.println(s+","+mid+","+e+":"+rate);
				if (rate > Z) {
					result = mid;
					e = mid;
				}
				else if (rate <= Z){
					s = mid + 1;
				}
			}
			if(result > 1000000000)
				System.out.println(-1);
			else
				System.out.println(result);
		}
	}
}
