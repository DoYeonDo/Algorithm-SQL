package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


//Map과 PriorityQueue 함께 사용
public class BOJ_20920_영단어암기는괴로워 {
	static class Info implements Comparable<Info>{
		String str;
		int cnt;
		
		Info(String str, int cnt){
			this.str = str;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Info info) {
			if(this.cnt == info.cnt) {
				if(this.str.length() == info.str.length()){
					return this.str.compareTo(info.str);
				}
				else {
					return info.str.length() - this.str.length();
				}
			}
			else {
				return info.cnt - this.cnt;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		PriorityQueue<Info> pq = new PriorityQueue<>();
		
		for(int cnt = 0; cnt < N; cnt++) {
			String str = br.readLine();
			
			if(str.length() < M)
				continue;
			
			if(!map.containsKey(str))
				map.put(str, 1);
			else {
				int num = map.get(str);
				map.put(str, num+1);
			}
			
			int num = map.get(str);
			pq.offer(new Info(str, num));
		}
		
		Set<String> set = new LinkedHashSet<>();
		while(!pq.isEmpty()) {
			Info i = pq.poll();
			
			set.add(i.str);
		}
		
		for(String ans : set) {
			sb.append(ans+"\n");
		}
		
		System.out.print(sb);
	}
}
