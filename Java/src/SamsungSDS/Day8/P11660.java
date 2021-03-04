package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11660 {
	static int N, M;
	static int [][] num;
	static long [][] sum;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int [N+1][N+1];
		sum = new long [N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int linesum = 0;
			for (int j = 1; j <= N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				linesum += num[i][j];
				sum[i][j] = sum[i-1][j] + linesum;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(sum[i]));
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			long result = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
			
			System.out.println(result);
		}
	}

}
