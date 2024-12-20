import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int idx = 1; idx < arrayA.length; idx++){
            gcdA = gcd(arrayA[idx], gcdA);
            gcdB = gcd(arrayB[idx], gcdB);
        }
        
        if(isNotDivide(arrayB, gcdA))
            if(answer < gcdA)
                answer = gcdA;
        
        if(isNotDivide(arrayA, gcdB))
            if(answer < gcdB)
                answer = gcdB;
        
        return answer;
    }
    
    static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    
    static boolean isNotDivide(int[] arr, int num){
        for(int value : arr)
            if(value % num == 0)
                return false;
        
        return true;
    }
}