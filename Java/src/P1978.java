import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P1978 {
	static int N, cnt=0;
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean [] sosu = new boolean [1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		
		sosu[1] = true;
		for (int i = 2; i < sosu.length; i++) {
			if(!sosu[i]) {
				for (int j = i*2; j < sosu.length; j+=i) {
					sosu[j] = true;
				}
			}
		}
//		for (int i = 1; i < sosu.length; i++) {
//			if(!sosu[i])
//				System.out.print(i+" ");
//		}
//		System.out.println();
		for(int item : arr) {
			if(!sosu[item]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}

}
