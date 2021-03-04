package Day3;

import java.util.Arrays;
import java.util.Scanner;

public class CandyBox {
	static int S, N, max;
	static int A, B, C;
	static long [] tree;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		max = 10000001;
		
		S=1;
		while(S < max) {
			S *= 2;
		}
		
		tree = new long[2*S];
		
		int a, b;
		long c;
		for(int n=0; n < N ; n++) {
			a = sc.nextInt();
			if (a == 1) {
				b = sc.nextInt();
				int index = search(1, 1, S, b);
				update(1, 1, S, index, -1);
				System.out.println(index);
			}
			else if (a == 2) {
				b = sc.nextInt();
				c = sc.nextLong();
				update(1, 1, S, b, c);
			}
		}
		System.out.println(sb.toString());
	}
	static long makeTree(int node, int left, int right) {
		//리프 노드
		if(left == right) {
			return tree[node] = 0;
		}
		
		//리프가 아니면 mid를 나누고, makeTree호출
		int mid = (left + right) / 2; 
		tree[node] = makeTree(node*2, left, mid);
		tree[node] += makeTree(node *2+1, mid + 1, right);
		
		return tree[node];
	}
	static int search(int node, int left, int right, int rank) {
		if (left == right) {
			return left;
		} else {
			int mid = (left + right) / 2;
			if (tree[node * 2] >= rank) {			//왼쪽 자식에서 사탕이 존재하는 경우
				return search(node*2, left,  mid,  rank);
			}else {								//오른쪽 자식에서 사탕이 존재하는 경우
				rank -= tree[node * 2];	//왼쪽 사탕들을 제거
				return search(node * 2 + 1, mid+1, right, rank);
			}
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
