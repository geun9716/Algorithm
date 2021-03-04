package Day3;

import java.util.Arrays;
import java.util.Scanner;

public class Boggle {
	// 우, 좌, 상, 하, 우상, 우하, 좌상, 좌하 
	static int[] mx = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] my = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[] score = {0, 0, 1, 1, 2, 3, 5, 11};
	
	static int W, B, cnt=0, hit=0;
	static char [][]board = new char[4][4];
	static boolean [][] visited = new boolean[4][4];
	static String max = "";
	static StringBuilder sb;
	static TrieNode root = new TrieNode();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		W = sc.nextInt();
		
		for(int i=0; i<W ; i++) {
			insert(sc.next());
		}
//		System.out.println(root.toString("",0));
		B = sc.nextInt();
		for(int i=0 ; i < B ; i++) {
			for (int n=0; n < 4; n++) {
				String tmp = sc.next();
				for(int m=0; m<4; m++) {
					board[n][m] = tmp.charAt(m);
				}
			}
			
			for(int n=0; n < 4; n++) {
				for(int m=0; m < 4; m++) {
					if (root.hasChild(board[n][m])) {
						dfs(n , m, root);
//						search(n, m, 1, root.getChild(board[n][m]));
					}
				}
			}
			System.out.println(cnt+" "+max+" "+hit);
			root.clearHit();
			max = "";
			cnt = 0;
			hit=0;
		}
	}
	static void dfs(int x, int y, TrieNode current) {
		// 1. 체크인
		visited[x][y] = true;
		sb.append(board[x][y]);
		current = current.children[board[x][y] - 'A'];
		// 2. 목적지에 도착했는가? 
		if(current.isEnd && !current.isHit) {
			current.isHit = true;
			hit++;
			String foundword = sb.toString();
			cnt += score[foundword.length()-1];
//			System.out.println(foundword+","+cnt);
			if(compare(max, foundword) > 0) {
				max = foundword;
			}
			if(foundword.length() >= 8) {
				visited[x][y] = false;
				sb.deleteCharAt(sb.length()-1);
				return ;
			}
		}
		// 3. 연결된 곳을 순회
		for(int i = 0 ; i < 8; i++) {
			int tx = x + mx[i];
			int ty = y + my[i];
			//4. 갈수 있는가? if (맵을 벗어나지 않고)
			if ((0 <= tx && tx < 4) && (0 <= ty && ty < 4)) {
				int Index = board[tx][ty] - 'A';
				// 4. 갈 수 있는가?
				if(!visited[tx][ty] && current.children[Index] != null) {
					// 5. 간다
//					System.out.println(tx+","+ty+","+(char)board[tx][ty]);
					dfs(tx, ty, current);
				}
			}
		}
		// 6. check out 
		visited[x][y] = false;
		sb.deleteCharAt(sb.length()-1);
	}
	static void search(int x, int y, int length, TrieNode node) {
		visited[x][y] = true;
		sb.append(board[x][y]);
		if (node.isEnd && !node.isHit) {
			node.isHit = true;
			cnt += score[length-1];
			hit++;
			String foundword = sb.toString();
			System.out.println(foundword);
			if(compare(max, foundword) > 0)
				max = foundword;
		}
		for(int i = 0 ; i < 8; i++) {
			int tx = x + mx[i];
			int ty = y + my[i];
			//4. 갈수 있는가? if (맵을 벗어나지 않고)
			if ((0 <= tx && tx < 4) && (0 <= ty && ty < 4)) {
				int Index = board[tx][ty] - 'A';
				// 4. 갈 수 있는가?
				if(!visited[tx][ty] && node.hasChild(board[tx][ty])) {
//					System.out.println(tx+","+ty+","+(char)board[tx][ty]);
					search(tx, ty, length+1, node.getChild(board[tx][ty]));
				}
			}
		}
		visited[x][y] = false;
		sb.deleteCharAt(length-1);
	}
	
	static void insert(String word) {
		TrieNode current = root;
		for (int i = 0 ; i < word.length(); i++) {
			int wordIndex = word.charAt(i) - 'A';
			if(current.children[wordIndex] == null) {
				current.children[wordIndex] = new TrieNode();
			}
			current = current.children[wordIndex];
		}
		current.isEnd = true;
	}
	static boolean containsNode(String word) {
		TrieNode current = root;
		for (int i = 0 ; i < word.length(); i++) {
			int wordIndex = word.charAt(i) - 'A';
			if (current.children[wordIndex] == null) {
				return false;
			}
			current = current.children[wordIndex];
		}
		return current.isEnd;
	}
	static int compare(String arg0, String arg1) {
		int result = Integer.compare(arg1.length(), arg0.length());
		if (result == 0) {
			return arg0.compareTo(arg1);
		} else {
			return result;
		}
	}
}

class TrieNode{
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;
	boolean isHit;
	public void clearHit() {
		isHit = false;
		for(int i=0;i < children.length; i++) {
			if(children[i] != null) {
				children[i].clearHit();
			}
		}
	}
	boolean hasChild(char c) {
		return children[c - 'A'] != null;
	}
	TrieNode getChild(char c) {
		return children[c - 'A'];
	}
	
	public String toString(String current, int depth) {
		StringBuilder sb = new StringBuilder(current);
		sb.append(isEnd ? "." : "");
		for(int i = 0 ; i < children.length; i++) {
			if(children[i] != null) {
				sb.append("\n");
				for(int j=0; j < depth; j++) {
					sb.append("_");
				}
				sb.append(children[i].toString((char)('A' + i)+"", depth + 1));
			}
		}
		return sb.toString();
	}
}
