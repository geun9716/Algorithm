package Day3;

import java.util.Arrays;
import java.util.Scanner;

public class IndexTree {
	static int S, N;
	static long [] tree, nums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new long[N+1];
		
		for (int n = 1 ; n <= N ; n++) {
			nums[n] = sc.nextLong();
		}
		System.out.println(Arrays.toString(nums));		
		S=1;
		while(S<N) {
			S *= 2;
		}
		tree = new long[2*S];
		
		makeTree(1, 1, S);
		System.out.println(Arrays.toString(tree));
		System.out.println(query(1, 1, S, 3, 7));
		update(1, 1, S, 3, -1);
		System.out.println(Arrays.toString(tree));
	}
	static long makeTree(int node, int left, int right) {
		//리프 노드
		if(left == right) {
			if (left <= N) {
				return tree[node] = nums[left];
			} else {
				return tree[node] = 0;
			}
		}
		
		//리프가 아니면 mid를 나누고, makeTree호출
		int mid = (left + right) / 2; 
		tree[node] = makeTree(node*2, left, mid);
		tree[node] += makeTree(node *2+1, mid + 1, right);
		
		return tree[node];
	}
	static long query(int node, int left, int right, int qLeft, int qRight) {
		if(qRight < left || right < qLeft) {	//쿼리 밖
			return 0;
		} else if (qLeft<= left && right <= qRight) {
			return tree[node];
		} else {
			int mid = (left + right) / 2;
			return query(node * 2, left, mid, qLeft, qRight) + query(node * 2+1, mid + 1, right, qLeft, qRight);
		}
	}
	
	static void update(int node, int left, int right, int index, long diff) {
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
