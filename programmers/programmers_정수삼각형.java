class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int row = 1; row < triangle.length; row++){
            for(int col = 0; col < triangle[row].length; col++){
                if(col==0)
                    triangle[row][col] += triangle[row-1][col];
                else if(col==triangle[row].length-1)
                    triangle[row][col] += triangle[row-1][col-1];
                else
                    triangle[row][col] = Math.max(triangle[row][col]+triangle[row-1][col-1], triangle[row][col]+triangle[row-1][col]);
            }
        }
        
        for(int col = 0; col < triangle[triangle.length-1].length; col++)
            answer = Math.max(answer, triangle[triangle.length-1][col]);
            
        return answer;
    }
}