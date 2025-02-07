package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CodeUp_3108_정올참여학생리스트만들기1 {
	static class Info{
		int no;
		String name;
		
		Info(int no, String name){
			this.no = no;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return no + " " + name;
		}
	}
	
	static Map<Integer, String> map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new TreeMap<>();
		int n = Integer.parseInt(br.readLine());
		for(int cnt = 0; cnt < n; cnt++) {
			String[] command = br.readLine().split(" ");
			
			String c = command[0];
			int no = Integer.parseInt(command[1]);
			String name = command[2];
			
			if(c.equals("I")) {
				if(!map.containsKey(no)) {
					map.put(no, name);
				}
			}
			else if(c.equals("D")) {
				if(map.containsKey(no)) {
					map.remove(no);
				}
			}
		}
		
		Info[] res = new Info[map.size()+1];
		int cnt = 1;
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry : set) {
			res[cnt++] = new Info(entry.getKey(), entry.getValue());
		}
		
		String[] idxArr = br.readLine().split(" ");
		for(int idx = 0; idx < idxArr.length; idx++) {
			int i = Integer.parseInt(idxArr[idx]);
			Info info = res[i];
			System.out.printf("%d %s\n", info.no, info.name);
		}
	}
}
