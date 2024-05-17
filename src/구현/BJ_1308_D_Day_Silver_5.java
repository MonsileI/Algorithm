package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1308_D_Day_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]f = new int[3];
        int[]s = new int[3];
        for(int i=0;i<3;i++)f[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++)s[i] = Integer.parseInt(st.nextToken());
        if(s[0] - f[0] > 1000 || s[0] - f[0] == 1000 && (f[1] < s[1] || f[1] == s[1] && f[2] <= s[2])) System.out.println("gg");
        else{
            int a = calc(f);
            int b = calc(s);
            System.out.println("D-"+(b-a));
        }
    }
    static int calc(int[]arr){
        int [] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;
        for(int i=1;i<arr[0];i++){
            days += 365 + checkYear(i);
        }
        for(int i=1;i<arr[1];i++){
            if(i==2) days += checkYear(arr[0]);
            days += day[i];
        }
        days += arr[2];
        return days;
    }
    static int checkYear(int y){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
}
