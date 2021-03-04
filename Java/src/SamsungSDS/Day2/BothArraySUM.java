package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BothArraySUM {
	static int T, N, M;
	static int [] A, B;
	static ArrayList<Long> subA = new ArrayList<>();
	static ArrayList<Long> subB = new ArrayList<>();
	static int head=0, tail=0;
	static long sum=0, cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N = sc.nextInt();
		A = new int [N];
		for(int n=0; n < N; n++) {
			A[n] = sc.nextInt();
		}
		M = sc.nextInt();
		B = new int [M];
		for(int m=0; m < M; m++) {
			B[m] = sc.nextInt();
		}
		for(int i=0 ; i < N ; i++) {
			sum += A[i];
			subA.add(sum);
			for(int j=i+1; j < N; j++) {
				sum += A[j];
				subA.add(sum);
			}
			sum = 0;
		}
		for(int i=0 ; i < M; i++) {
			for(int j=i, m=i; j < M; j++) {
				while(m <= j) {
					sum += B[m++];
					subB.add(sum);
				}
			}
			sum = 0;
		}
		Collections.sort(subA);
		Collections.sort(subB,Collections.reverseOrder());
		
		while(head < subA.size() && tail < subB.size()) {
			long currentA = subA.get(head);
			long target = T-currentA;
			if(subB.get(tail) > target) {
				tail++;
			}
			else if (subB.get(tail) == target) {
				long cnt_a=0, cnt_b=0;
				while(head < subA.size() && currentA == subA.get(head)) {
					head++;
					cnt_a++;
				}
				while(tail < subB.size() && target == subB.get(tail)) {
					tail++;
					cnt_b++;
				}
				cnt += cnt_a * cnt_b;
			}
			else {
				head++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
