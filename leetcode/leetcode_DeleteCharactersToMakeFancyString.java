class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        char prevCh = s.charAt(0);
        int cnt = 1;

        for(int idx = 1; idx < s.length(); idx++){
            char curCh = s.charAt(idx);

            if(prevCh == curCh){
                cnt++;
                if(cnt < 3){
                    sb.append(s.charAt(idx));
                }
            }
            else{
                cnt = 1;
                sb.append(s.charAt(idx));
            }

            prevCh = curCh;
        }

        return sb.toString();
    }
}