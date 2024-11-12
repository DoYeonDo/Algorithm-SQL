class Solution {
    public int solution(String s) {
        int maxLength = 1;

        for (int center = 0; center < s.length(); center++) {
            // 홀수 길이 팰린드롬 검사 (ex: "aba")
            maxLength = Math.max(maxLength, expandAroundCenter(s, center, center));
            // 짝수 길이 팰린드롬 검사 (ex : "abba")
            maxLength = Math.max(maxLength, expandAroundCenter(s, center, center + 1));
        }

        return maxLength;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}
