import java.util.Scanner;

public class P1011 {
	static int T, k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		while(T-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int distance = y - x;
			
			int max = (int)Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				System.out.println(2 * max - 1);
			}
			else if (distance <= max * max + max) {
				System.out.println(2 * max);	
			}
			else {
				System.out.println(2 * max + 1);
			}
		}
		sc.close();
	}

}
