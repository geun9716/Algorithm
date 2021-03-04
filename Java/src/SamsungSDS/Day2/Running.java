package Day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Running {
	static ArrayList<Long> list = new ArrayList<>();
	static Runner [] race, temp;
	static int [] ranks;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		race = new Runner[N];
		temp = new Runner[N];
		ranks = new int [N];
		
		for(int n=0; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			race[n] = new Runner(Long.parseLong(st.nextToken()), n);
		}
		
		mergeSort(0, N-1);
		
		StringBuilder sb = new StringBuilder(); //단일쓰레드로 속도가 빠름
//		StringBuffer // 멀티쓰레드로 속도가 느림 
		for (int n=0; n < ranks.length; n++) {
			sb.append(n+1 - ranks[n]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
		
	}
	static void mergeSort(int s , int e) {
		if (s < e) {
			int mid = (s + e) / 2;
			mergeSort(s, mid);
			mergeSort(mid+1, e);
			merge(s, mid, e);
		}
	}
	static void merge(int s, int m, int e) {
		int p1 = s;
		int p2 = m+1;
		int k = s;
		while(p1 <= m && p2 <= e) {
			if(race[p1].value >= race[p2].value) {
				temp[k++] = race[p1++];
			} else {
				ranks[race[p2].position] += (p2-k);
				temp[k++] = race[p2++];
			}
		}
		while (p1 <= m) {
			temp[k++] = race[p1++];
		}
		while (p2 <= e) {
			temp[k++] = race[p2++];
		}
		for(int i = s; i <= e; i++) {
			race[i] = temp[i];
		}
	}
}
class Runner{
	long value;
	int position;
	public Runner(long value, int position) {
		this.value = value;
		this.position = position;
	}
	@Override
	public String toString() {
//		return "Runner [value=" + value + ", position=" + position + "]";
		return Long.toString(value);
	}
}


// 시간 초과 코드
//public class Running {
//	static ArrayList<Long> list = new ArrayList<>();
//	static ArrayList<Long> rank = new ArrayList<>();
//	static long [] race;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		race = new long[N];
//		for(int n=0; n < N ; n++) {
//			long cnt = 1;
//			race[n] = sc.nextLong();
//			for(long a : list) {
//				if(race[n] < a)
//					cnt++;
//			}
//			list.add(race[n]);
//			rank.add(cnt);
//		}
//		for(long a : rank)
//			System.out.println(a);
//		sc.close();
//	}
//}
