package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class subsum {
	static int N, S;
	static int head=0, tail=0, sum=0, min=100000;
	static int [] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int [N+1];
		for(int n = 0 ; n < N; n++){
			arr[n] = sc.nextInt();
		}
		sum = arr[head];
		
		while(head < N && tail < N) {
			if (sum < S) {
				sum += arr[++tail];
			}
			else if (sum == S) {
				int len = tail - head;
//				System.out.println(head+","+tail+","+len);
				if (len < min) 
					min = len;
				sum += arr[++tail];
			}
			else {
				int len = tail - head;
//				System.out.println(head+","+tail+","+len);
				if (len < min) 
					min = len;
				sum -= arr[head++];
			}
//			System.out.println(Arrays.toString(arr));
		}
		if (min == 100000)
			System.out.println(0);
		else
			System.out.println(min+1);
		
		sc.close();
	}
}
