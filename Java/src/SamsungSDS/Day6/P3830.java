package Day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3830 {
	static int n, m;
	static int [] p, weight;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0)
				break;
			
			weight = new int[n+1];
			p = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			
			String cmd;
			int a, b, w;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				cmd = st.nextToken();
				if(cmd.charAt(0) == '!') {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					w = Integer.parseInt(st.nextToken());
					
					union(a,b, w);
					
				}
				else if (cmd.charAt(0) == '?') {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					
					if(find(a) == find(b)) {
						if(weight[find(a)] > 0)
							System.out.println(weight[find(a)]);
						else
							System.out.println(-1);
					}
					else {
						System.out.println("UNKNOWN");
					}
				}
				System.out.println();
			}
		}
		
	}
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b, int w) {
		a = find(p[a]);
		b = find(p[b]);
		
		
		p[a] = b;
	}
}
