import java.util.*;

class Solution {
    static class ServerInfo{
        int serverCnt;
        int remainTime;
        
        ServerInfo(int serverCnt, int remainTime){
            this.serverCnt = serverCnt;
            this.remainTime = remainTime;
        }
        
        void reduceOneMinute(){
            this.remainTime--;
        }
    }
    
    static List<ServerInfo> servers;
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int totalServerCnt = 0;
        servers = new ArrayList<>();
        
        for(int time = 0; time < players.length; time++){
            for(int idx = servers.size()-1; idx >= 0; idx--){
                ServerInfo serverInfo = servers.get(idx);
                
                serverInfo.reduceOneMinute();
                
                if(serverInfo.remainTime==0){
                    totalServerCnt -= serverInfo.serverCnt;
                    servers.remove(idx);
                }
            }
            
            int player = players[time];
            
            if(players[time] < m) continue;
            
            int requiredServerCnt = player / m;
            if(totalServerCnt >= requiredServerCnt) continue;
            
            int addServerCnt = requiredServerCnt - totalServerCnt;
            totalServerCnt += addServerCnt;
            answer += addServerCnt;
            
            servers.add(new ServerInfo(addServerCnt, k));
        }
        
        return answer;
    }
}