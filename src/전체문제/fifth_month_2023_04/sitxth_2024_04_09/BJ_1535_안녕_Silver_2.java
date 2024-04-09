package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_1535_안녕_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]v = new int[N+1]; int[]w = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) w[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) v[i] = Integer.parseInt(st.nextToken());
        int[][]dp = new int[N+1][100];
        int max = 0;
        for(int i=1;i<N+1;i++){
            int weight = w[i];
            for(int j=1;j<100;j++){
                dp[i][j] = dp[i-1][j];
                if(weight<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+v[i]);
                }
            }
            max = Math.max(max,dp[i][99]);
        }
        System.out.println(max);
    }
}
