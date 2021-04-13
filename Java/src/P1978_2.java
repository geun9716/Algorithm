import java.util.ArrayList;
import java.util.Scanner;

public class P1978_2 {
	static int N, cnt = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		
		for (int item : arr) {
			boolean issosu = true;
			if(item == 1) {
				continue;
			}
			for (int i = 2; i < item; i++) {
				if (item%i == 0) {
					issosu = false;
					break;
				}
			}
			
			if(issosu) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
