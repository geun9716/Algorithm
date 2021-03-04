package Day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SUM2 {
	static int N, M;
	static int sum=0, head=0, tail=0, cnt=0;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("src\\Day2\\SUM2\\input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String line = br.readLine();
//		
//		StringTokenizer st = new StringTokenizer(line);
//		
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0 ; i < N ; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int [N + 1];
		for(int n = 0 ; n < N; n++)
			arr[n] = sc.nextInt();
		System.out.println(Arrays.toString(arr));
		
		sum += arr[head];
		
		while(head < N && tail < N) {
			if (sum < M) {
				if (++tail >= N)
					break;
				sum += arr[tail];
			}
			else if (sum == M) {
				cnt++;
				if (++tail >= N)
					break;
				sum += arr[tail];
			}
			else {
				sum -= arr[head++];
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}



