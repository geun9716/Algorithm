package Day2;

import java.util.ArrayList;
import java.util.Scanner;

public class CuttingWood {
	static int N;
	static long M;
	static long [] woods;
	static long start=0, end=0, mid=0, result = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		M = sc.nextInt();
		woods = new long [N];
		
		for(int n=0; n < N ;n++) {
			woods[n] = sc.nextLong();
			end = Math.max(woods[n], end);
		}
		
		while(true)
		{
			mid = (start+end)/2;
			long sum = SUM(mid);
			
			if(sum < M) {
				end = mid-1;
			}
			else if (sum == M) {
				result = mid;
				break;
			}
			else {
				result = mid;
				start = mid+1;
			}
			
			if (start > end)
				break;
		}
		System.out.println(result);
		sc.close();
	}
	public static long SUM(long height) {
		long result=0;
		for(long wood : woods) {
			if((wood-height)>0)
				result += (wood-height);
		}
		return result;
	}
}
