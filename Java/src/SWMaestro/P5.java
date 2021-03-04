package SWMaestro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P5 {
	static int N, result = 0;
	static ArrayList<rat> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N*N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = 0; j < y; j++) {
				list.add(new rat(x, sc.nextInt()));
			}
		}
		
		list.sort(new Comparator<rat>() {
			@Override
			public int compare(rat o1, rat o2) {
				int tmp = Integer.compare(o1.t, o2.t);
				if(tmp == 0) {
					return Integer.compare(o2.score, o1.score);
				}
				else {
					return tmp;
				}
			}
		});
		
		int pre = 0;
		for (int i = 0; i < list.size(); i++) {
			rat cur = list.get(i);
			if (cur.t == pre) {
				continue;
			}
			result += cur.score;
			pre = cur.t;
		}
		
		System.out.println(result);
		sc.close();
	}
}
class rat{
	int score;
	int t;
	
	public rat(int score, int t) {
		this.score = score;
		this.t = t;
	}

	@Override
	public String toString() {
		return "rat [score=" + score + ", t=" + t + "]";
	}
	
}

/*
2
1 3 1 3 5
2 2 2 4
3 2 1 2
4 1 3

13
 */