package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659_2 {
	static int N, M, S;
	static int [] num, sum_1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int [N+1];
		sum_1 = new int [N+1];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum_1[i] = sum_1[i-1] + num[i];
		}
		
//		System.out.println(Arrays.toString(num));
//		System.out.println(Arrays.toString(sum_1));
		
				
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result;
			
			// num[1]이 2번 빼지기 때문 
			sb.append(sum_1[b] - sum_1[a-1]);
			sb.append('\n');
		}		
		System.out.println(sb.toString());
	}
}
