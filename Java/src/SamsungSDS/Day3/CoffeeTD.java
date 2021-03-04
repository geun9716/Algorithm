package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoffeeTD {
	static long S;
	static int N, Q;
	static int [] tree, nums;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		nums = new int [N+1];
		st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N ; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		}
		
		S = 1;
		while (S < N) {
			S *= 2;
		}
		tree = new int [(int)(S * 2)];
		makeTree(1, 1, (int)S);
//		System.out.println(Arrays.toString(tree));
		
		int x, y, a, b;
		for(int q=0; q<Q ; q++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			System.out.println(query(1, 1, (int)S, x, y));
			update(1, 1, (int)S, a, b - tree[(int)S+a-1]);
//			System.out.println(Arrays.toString(tree));
		}
	}
	static int makeTree(int node, int left, int right) {
		//리프 노드
		if(left == right) {
			if (left <= N) {
				tree[node] = nums[left];
			} else {
				tree[node] = 0;
			}
			return tree[node];
		}
		
		//리프가 아니면 mid를 나누고, makeTree호출
		int mid = (left + right) / 2; 
		tree[node] = makeTree(node*2, left, mid);
		tree[node] += makeTree(node *2+1, mid + 1, right);
		
		return tree[node];
	}
	static int query(int node, int left, int right, int qLeft, int qRight) {
		if(qRight < left || right < qLeft) {	//쿼리 밖
			return 0;
		} else if (qLeft<= left && right <= qRight) {
			return tree[node];
		} else {
			int mid = (left + right) / 2;
			return query(node * 2, left, mid, qLeft, qRight) + query(node * 2+1, mid + 1, right, qLeft, qRight);
		}
	}
	
	static void update(int node, int left, int right, int index, int diff) {
		if (left <= index && index <= right) {
			tree[node] += diff;
			if (left != right) {
				int mid = (left + right) / 2;
				update(node * 2, left, mid, index, diff);
				update(node * 2 + 1, mid +1, right, index, diff);
			}
		}
	}
}
