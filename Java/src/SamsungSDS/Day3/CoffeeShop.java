package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoffeeShop {
	static int S;
	static long N, Q;
	static long [] tree, nums;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		nums = new long [(int)N+1];
		st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N ; n++) {
			nums[n] = Long.parseLong(st.nextToken());
		}
		
		S = 1;
		while (S < N) {
			S *= 2;
		}
		tree = new long [(int)(S * 2)];
		makeTree();
//		System.out.println(Arrays.toString(tree));
		
		int x, y, a;
		long b;
		for(int q=0; q<Q ; q++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			if(x <= y)
				System.out.println(query(x, y));
			else
				System.out.println(query(y, x));
			update(a, b);
//			System.out.println(Arrays.toString(tree));
		}
	}
	static void makeTree() {
		for(int i=0; i < N; i++) {
			tree[S+i] = nums[i+1];
		}
		for(int i = S - 1; i > 0 ; i--) {
			tree[i] = tree[i*2] + tree[i*2 +1];
		}
	}
	static long query(int left, int right) {
		long sum = 0;
		left += S - 1;
		right += S - 1;
		while(left <= right) {
			if(left % 2 == 1) {
				sum += tree[left++];
			}
			if(right % 2 == 0) {
				sum += tree[right--];
			}
			left /= 2;
			right /= 2;
		}
		return sum;
	}
	static void update(int index, long value) {
		index += S - 1;
		tree[index] = value;
		index /= 2;
		while (index >= 1) {
			tree[index] = tree[index * 2] + tree[index * 2 + 1];
			index /= 2;
		}
	}
}
