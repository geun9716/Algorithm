package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659 {
	static int N, M, S;
	static int [] num, tree;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		S = 1;
		while(S < N) {
			S *=2;
		}
		num = new int [2*S];
		tree = new int [2*S];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[S+i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		
		System.out.println(Arrays.toString(num));
		
		makeTree(1,1,S);
		
		System.out.println(Arrays.toString(tree));
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(query(1, 1, S, a, b));
			sb.append('\n');
		}		
		System.out.println(sb.toString());
	}
	
	static int makeTree(int node, int start, int end) {
		if (start == end)
			return tree[node] = num[node];
		int mid = (start + end)/2;
		return tree[node] = makeTree(node*2, start, mid) + makeTree(node*2+1, mid+1, end); 
		
	}
	static int query(int node, int start, int end, int left, int right) {
		
		return 0;
	}

}
