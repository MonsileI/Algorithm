package 전체문제.fifth_month_2023_04.seventeenth_2024_04_25;

import java.util.*;
import java.io.*;
public class GR_엘리스트랙매칭_Level_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[]tmp = br.readLine().split(" ");
        char me = br.readLine().charAt(0);
        int ans = 0;
        for(int i=0;i<N;i++) if(tmp[i].charAt(0)==me) ans++;
        System.out.println(ans);


    }
}
