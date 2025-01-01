package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_7662_이중우선순위큐 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> pqReverse = new PriorityQueue<>(new Comparator<>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			
			for(int cnt = 0; cnt < k; cnt++) {
				String[] oper = br.readLine().split(" ");
				String dir = oper[0];
				int num = Integer.parseInt(oper[1]);
				
				if("I".equals(dir)) {
					map.put(num, map.getOrDefault(num, 0)+1);
					
					pq.offer(num);
					pqReverse.offer(num);
				}
				else {
					if(map.size()==0) continue;
					
					PriorityQueue<Integer> que = num==1 ? pqReverse:pq;
					remove(que, map);
				}
			}
			
			if(map.size()==0)
				sb.append("EMPTY\n");
			else {
				int maxValue = remove(pqReverse, map);
				sb.append(maxValue+" "+(map.size()>0 ? remove(pq, map):maxValue)+"\n");
			}
		}
		
		System.out.print(sb);
	}
	
	static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
		int num;
		
		while(true) {
			num = pq.poll();
			int cnt = map.getOrDefault(num, 0);
			
			if(cnt==0) continue;
			
			if(cnt==1)
				map.remove(num);
			else
				map.put(num, cnt-1);
			
			break;
		}
		
		return num;
	}
}
