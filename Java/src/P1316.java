import java.util.Scanner;

public class P1316 {
	static int N, result = 0;
	static boolean isGroup;
	static String input;
	static boolean [] alpha;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			input = sc.next();
			alpha = new boolean[26];
			isGroup = true;
			
			for (int j = 0; j < input.length(); j++) {
				int index = input.charAt(j) - 'a';
				if(alpha[index] && input.charAt(j-1) != input.charAt(j)) {
					isGroup = false;
					break;
				}
				alpha[index] = true;
			}
			if(isGroup) {
				result++;
			}
		}
		System.out.println(result);
		sc.close();
	}

}
