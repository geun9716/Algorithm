import java.util.Scanner;

public class P1193 {
	static int X, result = 1, cnt = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		
		//  2 3 4 5 6 
		// 1 3 6 10 15 20
		while(result < X) {
			result += ++cnt;
		}
		int tmp = (result - X)+1;
		cnt += 1;
//		System.out.println(result-X);
//		System.out.println(cnt);
//		System.out.println(tmp);
		if(cnt % 2 == 0) {
			//Â¦¼ö : ¾Æ·¡·Î
			System.out.println(tmp+"/"+(cnt-tmp));
		}
		else {
			//È¦¼ö : À§·Î
			System.out.println((cnt-tmp)+"/"+tmp);
		}
		
		sc.close();
	}

}
