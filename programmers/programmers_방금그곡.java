import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = 0;
        
        m = replaceString(m);
        for(String musicinfo : musicinfos){
            String[] splitMusicinfo = musicinfo.split(",");
            String startTime = splitMusicinfo[0];
            String endTime = splitMusicinfo[1];
            String title = splitMusicinfo[2];
            String music = splitMusicinfo[3];
            music = replaceString(music);

            int cnt = minutes(startTime, endTime);
            String iterateMusic = iterateString(music, cnt);

            if (iterateMusic.length() >= m.length() && iterateMusic.contains(m)) {
                if (cnt > maxPlayTime) {
                    maxPlayTime = cnt;
                    answer = title;
                }
            }
        }

        return answer.equals("") ? "(None)" : answer;
    }

    static String replaceString(String m){
        return m.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }

     static int minutes(String startTime, String endTime){
        String[] startTimeArr = startTime.split(":");
        String[] endTimeArr = endTime.split(":");
        
        int startHour = Integer.parseInt(startTimeArr[0]);
        int startMinute = Integer.parseInt(startTimeArr[1]);
        int endHour = Integer.parseInt(endTimeArr[0]);
        int endMinute = Integer.parseInt(endTimeArr[1]);
        
        if(startHour==endHour)
            return endMinute - startMinute;
        else{
            int total = 0;
            
            if(endMinute >= startMinute){
                total += endMinute - startMinute;
                total += (endHour - startHour) * 60;
            }
            else{
                total += (60+endMinute) - startMinute;
                total += (endHour - startHour - 1) * 60;
            }
            
            return total;
        }
    }

    static String iterateString(String music, int cnt){
        StringBuilder sb = new StringBuilder();
        int len = music.length();
        
        if(len <= cnt){
            int iterateCnt = cnt / len;
            for(int i = 0; i < iterateCnt; i++)
                    sb.append(music);
            
            if(cnt % len != 0){
                int remain = cnt % len;
                sb.append(music.substring(0, remain));
            }
        }
        else{
            sb.append(music.substring(0, cnt));
        }
        
        return sb.toString();
    }
}
