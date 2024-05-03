package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2852_NBA농구_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int f = 0; int s = 0;
        int timeF = 0; int timeS = 0;
        int before = 0;
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            int team = Integer.parseInt(st.nextToken());
            int time = toInt(st.nextToken());
            if(f>s) timeF += time - before;
            else if(f<s) timeS += time - before;
            before = time;
            if(team==1) f++;
            else s++;
        }
        if(f>s) timeF += 2880 - before;
        else if(f<s) timeS += 2880 - before;
        System.out.println(toTime(timeF)+"\n"+toTime(timeS));
    }
    static String toTime(int num){
        String hour = String.valueOf(num / 60);
        String minute = String.valueOf(num % 60);
        if(hour.length()==1) hour = "0" + hour;
        if(minute.length()==1) minute = "0" +minute;
        return hour +":"+minute;
    }
    static int toInt(String str){

        String[]tmp  =str.split(":");
        int time = (Integer.parseInt(tmp[0]) * 60) + (Integer.parseInt(tmp[1]));
        return time;

    }
}
