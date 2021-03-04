import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int result=0;
	static String b;
	static Stack<Character> st = new Stack<>(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	sc = new Scanner(System.in);
		b = sc.next();
		
		for (int i = 0; i < b.length(); i++) {
			char cur = b.charAt(i);
			
			if(cur == '(') {
				result--;
			}
			else if (cur == ')') {
				result++;
			}
		}
		
		if(result < 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
		
		sc.close();
	}

}
