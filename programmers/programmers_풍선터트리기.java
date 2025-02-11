class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int size = a.length;
        if(size == 1) return 1;
        
        int[] leftMin = new int[size];
        int[] rightMax = new int[size];
        int left = a[0];
        int right = a[size-1];
        
        for(int idx = 1; idx < size-1; idx++){
            if(left > a[idx])
                left = a[idx];
            leftMin[idx] = left;
        }
        
        for(int idx = size-2; idx > 0; idx--){
            if(right > a[idx])
                right = a[idx];
            rightMax[idx] = right;
        }
        
        answer = 2;
        for(int idx = 1; idx <= size-2; idx++){
            if(a[idx]>leftMin[idx] && a[idx]>rightMax[idx]) continue;
            answer++;
        }
        
        return answer;
    }
}