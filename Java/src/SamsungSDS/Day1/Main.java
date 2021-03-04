package Day1;
import java.util.*;

public class Main {
	static Stack <Long> stack = new Stack<>();
	static List <Command> commands = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long tmp;
		Long tmp2;
		boolean err = false;
		Long result;
		while(true) {
			while(true) {		//Input Command
				String[] s = sc.nextLine().split(" ");
				if(s[0].equals("QUIT")) {
					System.out.println();
					return ;
				}
				if(s[0].equals("END"))
					break;
				if (s.length > 1)
					commands.add(new Command(s[0], Long.parseLong(s[1])));
				else
					commands.add(new Command(s[0], 0));
			}
			int N = sc.nextInt();
			for(int i = 0 ; i < N ; i++) {
				long input = sc.nextLong();
				stack.add(input);
				
				for(Command command : commands) {
					if(command.cm.equals("NUM")){
						stack.add(command.param);
					}
					else if (command.cm.equals("POP")) {
						if(!stack.isEmpty()) {
							stack.pop();
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("INV")) {
						if(!stack.isEmpty()) {
							stack.add(stack.pop() * (-1));
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("DUP")) {
						if(!stack.isEmpty()) {
							stack.add(stack.peek());
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("SWP")) {
						if(stack.size() >= 2) {
							tmp = stack.pop();
							tmp2 = stack.pop();
							stack.add(tmp);
							stack.add(tmp2);
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("ADD")) {
						if(stack.size() >= 2) {
							tmp = stack.pop();
							result = stack.pop() + tmp;
							if (Math.abs(result) > 1000000000) {
								err = true;
								break;
							}
							stack.add(result);
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("SUB")) {
						if(stack.size() >= 2) {
							tmp = stack.pop();
							result = stack.pop() - tmp;
							if (Math.abs(result) > 1000000000){
								err = true;
								break;
							}
							stack.add(result);
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("MUL")) {
						if(stack.size() >= 2) {
							tmp = stack.pop();
							result = stack.pop() * tmp;
							if (Math.abs(result) > 1000000000){
								err = true;
								break;
							}
							stack.add(result);
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("DIV")) {
						if(stack.size() >= 2) {
							tmp = stack.pop();
							if (tmp == 0){
								err = true;
								break;
							}
							result = stack.pop() / tmp;
							if (Math.abs(result) > 1000000000){
								err = true;
								break;
							}
							stack.add(result);
						} else {
							err = true;
							break;
						}
					}
					else if (command.cm.equals("MOD")) {
						if(stack.size() >= 2) {
							tmp = stack.pop();
							if (tmp == 0){
								err = true;
								break;
							}
							result = stack.pop() % tmp;
							if (Math.abs(result) > 1000000000){
								err = true;
								break;
							}
							stack.add(result);
						} else {
							err = true;
							break;
						}
					}
				}
				if (stack.size() != 1 || err)
				{
					stack.clear();
					System.out.println("ERROR");
					err = false;
				}
				else {
					if(!stack.isEmpty()) {
						System.out.println(stack.pop());
					}
				}
			}
		System.out.println();
		commands.clear();
		}
	}
}

class Command{
	String cm;
	long param;
	public Command(String cm, long param) {
		this.cm = cm;
		this.param = param;
	}
}
