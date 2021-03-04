package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MinHeap mh = new MinHeap();
		N = sc.nextInt();
		
		for(int n=0; n < N ; n++) {
			int input = sc.nextInt();
			if (input > 0)
			{
				mh.insert(input);
			}
			else {
				System.out.println(mh.delete());
			}
		}
	}

}
class MinHeap{
	List<Integer> heap;
	
	public MinHeap() {
		heap = new ArrayList<>();
		heap.add(0);
	}

	public void insert(int val) {
		//제일 끝에 항목 추가
		heap.add(val);
		int current = heap.size()-1;
		int parent = current / 2;
		while (true) {
			// 루트에 도달 한 경우
			if (current == 1 || heap.get(parent) < heap.get(current)) { // 부모가 나보다 작은 경우
				break;
			}
			// 부모가 나보다 큰 경우
			int tmp = heap.get(current);
			heap.set(current, heap.get(parent));
			heap.set(parent, tmp);
			current = parent;
			parent = current / 2;
		}
	}
	
	public int delete() {
		// 루트 값을 제거 후 제일 마지막 값을 루트로 가져옴.
		if (heap.size() <= 1)
			return 0;
		int result = heap.get(1);
		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int currentPos = 1;
		while(true) {
			int left = currentPos*2;
			int right = currentPos*2+1;
			//자식 존재 여부 확인
			
			if(left >= heap.size()) {
				break;
			}
			//좌측, 우측 중 작은 값 선택
			int minValue = heap.get(left);
			int minPos = left;
			
			if(right < heap.size() && heap.get(right) < minValue) {
				minValue = heap.get(right);
				minPos = right;
			}
			
			if(minValue <heap.get(currentPos)) {
				int tmp = heap.get(currentPos);
				heap.set(currentPos, heap.get(minPos));
				heap.set(minPos, tmp);
				currentPos = minPos;
			}
			else {
				break;
			}
			// 선택된  자식이 자신보다 작은 경우
			// 선택된 자식이 자신보다 큰 경우
		}
		return result;
	}
}
