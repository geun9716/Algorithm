package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bracket {
	static Stack<OP> stack = new Stack<>();
	static int tmp = 0, n=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();		
		
		for(int i=0; i< line.length; i++) {
			if(line[i] == '(' || line[i] == '[') {
				stack.push(new OP(line[i], 0));
			}
			else if (stack.size() > 0 && line[i] == ')'){
				while (!stack.isEmpty()) {
					
				}
				while (stack.peek().value > 0) {
					tmp += stack.pop().value;
				}
				if (stack.peek().op == '(') {
					if (tmp > 0) {
						stack.pop();
						stack.push(new OP('\0',tmp * 2));
					}
					else {
						stack.pop();
						stack.push(new OP('\0',2));
					}
				}
				else
					break;
				tmp = 0;
			}
			else if (stack.size() > 0 && line[i] == ']'){
					
				while (stack.peek().value > 0) {
					tmp += stack.pop().value;
				}
				if (stack.peek().op == '[') {
					if (tmp > 0) {
						stack.pop();
						stack.push(new OP('\0',tmp * 3));
					}
					else {
						stack.pop();
						stack.push(new OP('\0',3));
					}
				}
				else
					break;
				tmp = 0;
			}
//			System.out.print(line[i]+" : ");
//			System.out.println(stack);
		}
		
		while(stack.size() > 0) {
			if (stack.peek().op != '\0') {
				tmp = 0;
				break;
			}
			tmp += stack.pop().value;
		}
		
		System.out.println(tmp);
	}
}
class OP{
	char op;
	int value;
	public OP(char op, int value) {
		this.op = op;
		this.value = value;
	}
	@Override
	public String toString() {
		return "OP [op=" + op + ", value=" + value + "]";
	}
}