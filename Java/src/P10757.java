import java.util.Arrays;
import java.util.Scanner;

public class P10757 {
	static char [] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char [] A = sc.next().toCharArray();
		char [] B = sc.next().toCharArray();
		
		int len_a = A.length-1;
		int len_b = B.length-1;
		int cnt = Math.max(A.length, B.length);
		result = new char [cnt+1];
		int tmp_a, tmp_b;
		int pre;
		while(cnt >= 0 && (len_a >= 0 && len_b >= 0)) {
			if (len_a >= 0) {
				tmp_a = (A[len_a--]-'0');
			}else {
				tmp_a = 0;
			}
			if (len_b >= 0) {
				tmp_b = (B[len_b--]-'0');
			} else {
				tmp_b = 0;
			}
			int tmp = tmp_a + tmp_b;
			if(tmp >= 10) {
				result[cnt-1] = (char)(tmp / 10);
			}
			result[cnt] = (char)(result[cnt] + tmp % 10 + '0');
			cnt--;
			System.out.println(result);
		}
		System.out.println(len_a);
		System.out.println(len_b);
		
//		while(len_a >= 0) {
//			result[cnt--] = A[len_a--];
//		}
//		
//		while(len_b >= 0 ) {
//			result[cnt--] = B[len_a--];
//		}

		System.out.println(result);
		
		
		sc.close();
	}

}
