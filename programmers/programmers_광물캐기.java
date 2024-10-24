class Solution {
    static int[] pickKnife;
    static int[] picksTmp;
    static int[][] hp;
    static int minHp = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        picksTmp = picks;
        hp = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        int knifeNum = 0;
        
        for(int pick : picks)
            knifeNum += pick;
        
        int arrLength = 0;
        if(minerals.length <= knifeNum*5){
            if(minerals.length %5 > 0)
                arrLength = minerals.length / 5 + 1;
            else
                arrLength = minerals.length / 5;
        }
        else
            arrLength = knifeNum;
        
        pickKnife = new int[arrLength];
        
        getcha(0, 0, 0, 0, minerals);
        answer = minHp;
        
        return answer;
    }
    
    private static void getcha(int diamond, int iron, int stone, int cnt, String[] minerals){
        if(cnt == pickKnife.length){
            int sum = 0;
            int idx = 0;
            int count = 0;
            for(int kindKnife : pickKnife){
                while(idx < minerals.length && count < 5){
                    if(minerals[idx].equals("diamond")){
                        sum += hp[kindKnife][0];
                    }
                    else if(minerals[idx].equals("iron")){
                        sum += hp[kindKnife][1];
                    }
                    else{
                        sum += hp[kindKnife][2];
                    }
                    
                    count++;
                    idx++;
                }
                count=0;
            }
            
            minHp = Math.min(minHp, sum);
            return;
        }
        
        if(diamond < picksTmp[0]) {
            pickKnife[cnt] = 0;
            getcha(diamond + 1, iron, stone, cnt + 1, minerals);
        }
        if(iron < picksTmp[1]) {
            pickKnife[cnt] = 1;
            getcha(diamond, iron + 1, stone, cnt + 1, minerals);
        }
        if(stone < picksTmp[2]) {
            pickKnife[cnt] = 2;
            getcha(diamond, iron, stone + 1, cnt + 1, minerals);
        }
    }
}