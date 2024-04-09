package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_5557_1학년_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())-1;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        //0이상 20이하 해서 goal이 되어야함
        int G = Integer.parseInt(st.nextToken());
        long[][]dp = new long[N][21];
        dp[0][arr[0]]++;
        for(int i=1;i<N;i++){
            for(int j=0;j<21;j++){
                if(dp[i-1][j]!=0){
                    if(arr[i]+j<21) dp[i][arr[i]+j] += dp[i-1][j];
                    if(j-arr[i]>-1) dp[i][j-arr[i]] += dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-1][G]);
    }
}
