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
		int i = 0;
		while(len_a >= 0 && len_b >= 0) {
			tmp_a = (A[len_a--]-'0');
			tmp_b = (B[len_b--]-'0');
			
			int tmp = result[i] + tmp_a + tmp_b;
			
			if(tmp >= 10) {
				result[i+1] = (char)(tmp / 10);
			}
			result[i] = (char)(tmp%10 + '0');
			i++;
		}
		
		while(len_a >= 0) {
			int tmp = (char)(result[i] + (A[len_a--]-'0'));
			if(tmp >= 10) {
				result[i+1] = (char)(tmp/10) ;
			}
			result[i++] = (char)(tmp%10 + '0');
		}
		while(len_b >= 0) {
			int tmp = (char)(result[i] + (B[len_b--]-'0'));
			if(tmp >= 10) {
				result[i+1] = (char)(tmp/10) ;
			}
			result[i++] = (char)(tmp%10 + '0');
		}
		result[cnt] += '0';
		if (result[cnt] == '0') {
			cnt-=1;
		}
		
		for(int j = cnt; j >= 0 ; j--) {
			System.out.print(result[j]);
		}
		
		sc.close();
	}

}
