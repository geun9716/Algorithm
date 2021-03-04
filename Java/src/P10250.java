import java.util.Scanner;

public class P10250 {
	static int T;
	static int X, Y;
	static String result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		while(T-- > 0) {
			int H, W, N;
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();
			
			X = (int)Math.ceil((double)N / H);
			Y = N % H;
			if (Y == 0) {
				Y = H;
			}
			if (X < 10) {
				System.out.println(Y +"0"+ X);
			}
			else {
				System.out.println(Y+""+X);
			}
		}
		
		sc.close();
	}

}
