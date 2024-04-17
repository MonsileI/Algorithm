package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_3135_라디오_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(Math.abs(S-num)<Math.abs(S-F)){
                F = num;
                ans = 1;
            }
        }
        ans += (Math.abs(F-S));
        System.out.println(ans);
    }
}
