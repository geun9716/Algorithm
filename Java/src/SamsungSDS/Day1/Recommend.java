package Day1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Recommend {
	static int N;
	static int R;
	static List<Person> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		boolean isThere = false;
		
		for (int r = 0 ; r < R ; r++) {
			int num = sc.nextInt();
			
			//앨범에 존재하는 경우
			for(Person p : list) {
				if (p.num == num) {
					p.count++;
					isThere = true;
					break;
				}
			}
			//앨범에 존재하지 않는 경우
			if (!isThere) {
				if(list.size() < N ) {		//앨범에 자리가 나는 경우
					list.add(new Person(num, 1, r));
				}
				else {						//앨범에 자리가 나지 않는 경우
					list.sort(new Comparator<Person>() {
						@Override
						public int compare(Person o1, Person o2) {
							if(o1.count < o2.count) {
								return -1;
							}
							else if (o1.count == o2.count) {
								if(o1.timeStamp < o2.timeStamp) {
									return -1;
								}
								else if (o1.timeStamp == o2.timeStamp) {
									return 0;
								}
								else {
									return 1;
								}
							}
							else {
								return 1;
							}
						}
					});
					list.remove(0);
					list.add(new Person(num, 1, r));
				}
			}
			isThere = false;
		}

		Collections.sort(list);
		for(Person a : list)
			System.out.print(a.num + " ");
	}
}
class Person implements Comparable<Person>{
//class Person {
	int num;
	int count;
	int timeStamp;
	
	public Person(int num, int count, int timeStamp) {
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "Person [num=" + num + ", count=" + count + ", timeStamp=" + timeStamp + "]";
	}
	@Override
	public int compareTo(Person o) {
		if(this.num < o.num) {
			return -1;
		}
		// 0 = Same = 바꾸지 않음.
		else if (this.num == o.num) {
			return 0;
		}
		// 1 = wrong order
		else {
			return 1;
		}
	}
}
