package Day1;

import java.util.*;
public class Teaching {
	static int N, K;
	static boolean[] visited;
	static String[] words;
	static int selectedCount = 0;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.next());
		K = Integer.parseInt(sc.next());
		
		words = new String[N];
		visited = new boolean[26];
		
		// a, n, t, i, c
		visited['a'- 'a'] = true;
		visited['n'- 'a'] = true;
		visited['t'- 'a'] = true;
		visited['i'- 'a'] = true;
		visited['c'- 'a'] = true;
		selectedCount = 5;
		
		if (K < 5) {
			System.out.println(0);
			return ;
		}
		
		
		//words 입력
		for(int i = 0; i < N; i++) {
			words[i] = sc.next().replaceAll("[antic]", "");
		}
		
		max = countWords();
		
		for(int i = 0; i < 26; i++) {
			if (visited[i] == false) {
				dfs(i);
			}
		}

		System.out.println(max);
	}
	
	static void dfs(int index) {
		// 1. check in -> visited[index] 체크, selectedCount++
		visited[index] = true;
		selectedCount++;
		
		// 2. isGoal -> selectedcount가 K -> 갱신
		if (selectedCount == K) {
			max = Math.max(countWords(), max);
		} else {
			// 3. linkedlist
			for(int i = index+1; i < 26; i++) {
				// 4. isCanGo? -> index + 1 ~ 26
				if (visited[i] == false) {
				// 5. go -> dfs(next)
					dfs(i);
				}
				
			}
		}
		// 6. check out -> visited[index] = false, selectedCount
		visited[index] = false;
		selectedCount--;
	}
	
	static int countWords() {
		int cnt = 0;
		boolean success = true;
		//check words
		for (String word : words) {
			success = true;
			for(int j = 0 ; j < word.length(); j++) {
				if (visited[word.charAt(j)-'a']==false) {
					success = false;
					break;
				}	
			}
			if (success) {
				cnt++;
			}
		}
		return cnt;
	}
}
