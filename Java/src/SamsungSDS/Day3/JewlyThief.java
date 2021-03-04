package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JewlyThief {

	static int N, K, i=0;
	static long result = 0;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	static Jewelry[] jewelries;
	static long [] bags;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		jewelries = new Jewelry[N];
		bags = new long[K];
		
		for(int n = 0 ; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			jewelries[n] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//			pq.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int k=0; k < K ; k++) {
			st = new StringTokenizer(br.readLine());
			bags[k] = Integer.parseInt(st.nextToken());
		}
		
		//가방 정렬
		Arrays.sort(bags);
//		System.out.println(Arrays.toString(bags));
		//보석 무게순 정렬
//		Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
		Arrays.sort(jewelries, new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				int r1 = Integer.compare(o1.weight, o2.weight);
				if(r1 == 0) {
					return Integer.compare(o2.value, o1.value);
				} else {
					return r1;
				}
			}
		});
//		PriorityQueue<Jewelry> pq2 = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getValue).reversed());
		//1. 남은 가방 중 제일 작은 가방을 선택. 
		for(int k=0; k < bags.length ; k++) {
			//2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택. <- 힙을 사용.
			while (i < jewelries.length && jewelries[i].getWeight() <= bags[k]) {
				pq.add(jewelries[i++].getValue());
			}
			if (!pq.isEmpty())
				result += pq.poll();
		}
		//3. 다음 가방 선택하여 1~2를 반복.
		
//		System.out.println(Arrays.toString(jewelries));
		//높은 값 기준 힙
		//정렬 O(n^2)을 없애자
		System.out.println(result);
	}
}

class Jewelry{
	int weight;
	int value;
	
	public Jewelry(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	public int getWeight() {
		return weight;
	}
	public int getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Jewelry [weight=" + weight + ", value=" + value + "]";
	}
}
