package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bracket_correct {
	static Stack<Element> stack = new Stack<>();
	static int tmp = 0, n=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();		
		
		for(int i=0; i< line.length; i++) {
			if(line[i] == '(' || line[i] == '[') {
				stack.push(new Element(line[i]));
			}
			else if (line[i] == ')'){
				tmp = 0;
				boolean isInvalid = false;
				while (!stack.isEmpty()) {
					Element e = stack.pop();
					if(e.isValue) { //numeric
						tmp += e.value;
					} else if (e.command == '(') {
						if (tmp > 0) {
							stack.push(new Element(tmp*2));
						}
						else {
							stack.push(new Element(2));
						}
						isInvalid = false;
						break;
					} else {
						isInvalid = true;
						break;
					}
				}
				if(isInvalid) {
					System.out.println(0);
					return;
				}
			}
			else if (line[i] == ']'){
				tmp = 0;
				boolean isInvalid = false;
				while (!stack.isEmpty()) {
					Element e = stack.pop();
					if(e.isValue) { //numeric
						tmp += e.value;
					} else if (e.command == '[') {
						if (tmp > 0) {
							stack.push(new Element(tmp*3));
						}
						else {
							stack.push(new Element(3));
						}
						isInvalid = false;
						break;
					} else {
						isInvalid = true;
						break;
					}
				}
				if(isInvalid) {
					System.out.println(0);
					return;
				}
			}
//			System.out.print(line[i]+" : ");
//			System.out.println(stack);
		}
		tmp = 0;
		while(stack.size() > 0) {
			Element e = stack.pop();
			if (e.isValue)
				tmp += e.value;
			else {
				tmp = 0;
				break;
			}
		}
		
		System.out.println(tmp);
	}
}
class Element {
	boolean isValue;
	int value;
	char command;
	public Element(int value) {
		this.isValue = true;
		this.value = value;
	}
	public Element(char command) {
		this.isValue = false;
		this.command = command;
	}
	@Override
	public String toString() {
		if(this.isValue)
			return Integer.toString(this.value);
		else
			return String.valueOf(this.command);
	}
}