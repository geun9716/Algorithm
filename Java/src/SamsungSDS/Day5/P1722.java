package Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P1722 {
	static int N, k;
	static long [] factorial;
	
	static int [] nums;
	static boolean [] visited;
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		factorial = new long[N+1];
		factorial[0] = 1;
		for (int i = 1; i <= N; i++) {
			factorial[i] = factorial[i-1] * i;
			list.add(i);
		}
		
		visited = new boolean[N+1];
		
		int command = sc.nextInt();
		
		if(command == 1) {
			long target = sc.nextLong();
			for(int i = 0 ; i < N; i++) {
				for (int j = 1; j <= N; j++) {
					if(visited[j] == true) {
						continue;
					}
					if(target > factorial[N-i-1]) {
						target -= factorial[N-i-1];
						
					} else {
						sb.append(j);
						sb.append(" ");
						visited[j] = true;
						break;
					}
				}
			}
			System.out.println(sb.toString());
		}
		else if (command == 2) {
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			long result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < nums[i]; j++) {
					if(visited[j] == false) {
						result += factorial[N-i-1];
					}
				}
				visited[nums[i]] = true;
			}
			System.out.println(result + 1);
		}
	}
}
