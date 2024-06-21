package 전체문제.seven_month_2024_06.thirteenth_2024_06_21;

import java.util.*;
public class PR_광고삽입_Level_3 {
    static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int N = logs.length;
        int end = change(play_time);
        int adv = change(adv_time);
        long[]sum = new long[500000];
        for(int i=0;i<N;i++){
            String [] tmp = logs[i].split("-");
            int start = change(tmp[0]);
            int finish =  change(tmp[1]);
            if(finish>end) finish = end;
            sum[start]++;
            sum[finish]--;
        }
        long s = 0;
        for(int i=0;i<end+1;i++){
            s += sum[i];
            sum[i] = s;
        }
        for(int i=1;i<end+1;i++) sum[i] += sum[i-1];
        long max = sum[adv];
        long ans = 0;
        for(int i=adv;i<end;i++){
            if(sum[i] - sum[i-adv]>max){
                max = sum[i] - sum[i-adv];
                ans = i-adv+1;
            }
        }
        answer = reverse(ans);
        return answer;
    }
    static String reverse(long time){
        String hour = ""+time/3600;
        if(hour.length()<2) hour = "0" +hour;
        time %= 3600;
        String min = ""+time/60;
        if(min.length()<2) min = "0" +min;
        time %= 60;
        String sec = ""+time;
        if(sec.length()<2) sec = "0" +sec;
        return hour+":"+min+":"+sec;
    }
    static int change(String time){
        String [] tmp = time.split(":");
        return ((Integer.parseInt(tmp[0])* 60) + Integer.parseInt(tmp[1])) * 60 + Integer.parseInt(tmp[2]);
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[]logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String result = "01:30:59";
        2.
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[]logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        String result = "01:00:00";
        3.
        String play_time = "50:00:00";
        String adv_time = "50:00:00";
        String[]logs = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};

        String result = "00:00:00";
        */
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[]logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};


        System.out.println(solution(play_time,adv_time,logs));
    }
}
