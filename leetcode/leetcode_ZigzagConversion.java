import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;

        List[] charList = new ArrayList[numRows];

        for(int row = 0; row < numRows; row++){
            charList[row] = new ArrayList<Character>();
        }

        int curRow = 0;
        boolean flag = true;
        for(int idx = 0; idx < s.length(); idx++){
            if(curRow==numRows){
                flag = !flag;
                curRow -= 2;
            }
            else if(curRow == -1){
                flag = !flag;
                curRow += 2;
            }

            charList[curRow].add(s.charAt(idx));

            if(flag)
                curRow++;
            else
                curRow--;
        }

        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < charList[row].size(); col++)
                sb.append(charList[row].get(col));
        }

        return sb.toString();
    }
}