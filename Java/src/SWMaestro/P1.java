package SWMaestro;

import java.util.ArrayList;
import java.util.Scanner;

public class P1 {
	static String [] K;
	static int N;
	static ArrayList<String> [] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextLine().split(" ");
		N = sc.nextInt();
		list = new ArrayList[K.length];
		
		for (int i = 0; i < K.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			String x = sc.next();
			String y = sc.next();
			for (int j = 0; j < K.length; j++) {
				if (x.equals(K[j])) {
					list[j].add(y);
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i].size() > 0) {
				System.out.print(K[i]+" ");
				
			}
			
			System.out.println(list[i]);
		}
		
		
		
		sc.close();
	}

}
