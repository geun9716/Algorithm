import java.util.Scanner;

public class P2292 {
	static int N, result=1, cnt=0;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		//  6  12  18  24
		// 1, 7, 19, 37, 61 
		
		while(result < N) {
			result = result + (6 * cnt);
			cnt++;
		}
		if(cnt == 0)
			System.out.println(1);
		else
			System.out.println(cnt);
		sc.close();
	}
}
