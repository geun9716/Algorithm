import java.util.Scanner;

public class P2941 {
	static int cnt = 0;
	static String [] alp = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		for (int i = 0; i < alp.length; i++) {
			if(input.contains(alp[i])) {
				input = input.replaceAll(alp[i], "*");
			}
		}
		
		System.out.println(input.length());
		
		sc.close();
	}
}
