package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ_1339_단어수학 {
	static int N;
	static int[] info = new int[26];
	static char[] arr;
	static int[] perm;
	static boolean[] visited = new boolean[10];
	static List<String> list = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Set<Character> set = new HashSet<>();
		
		for(int cnt = 0; cnt < N; cnt++) {
			String str = br.readLine();
			list.add(str);
			for(int idx = 0; idx < str.length(); idx++) {
				set.add(str.charAt(idx));
			}
		}
		
		arr = new char[set.size()];
		Arrays.sort(arr);
		perm = new int[set.size()];
		int idx = 0;
		for(char ch : set) {
			arr[idx++] = ch;
		}
		
		for(int i = 0; i < arr.length; i++) {
			info[(int)(arr[i]-'A')] = i;
		}
		
		perm(0);
		System.out.print(max);
	}
	
	private static void perm(int cnt) {
		if(cnt == arr.length) {
			int sum = 0;
			for(int idx = 0; idx < list.size(); idx++) {
				String str = list.get(idx);
				StringBuilder sb = new StringBuilder();
				for(int strIdx = 0; strIdx < str.length(); strIdx++) {
					int alphabet = str.charAt(strIdx) - 'A';
					sb.append(perm[info[alphabet]]);
				}
				sum += Integer.parseInt(new String(sb));
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int num = 0; num <= 9; num++) {
			if(!visited[num]) {
				visited[num] = true;
				perm[cnt] = num;
				perm(cnt+1);
				visited[num] = false;
			}
		}
	}
}
