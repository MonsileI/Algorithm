package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_2240_자두나무_Gold_5 {
    static int T,W;
    static int [][] dp;
    static int []arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][]dp = new int[T+1][W+1];
        int[]arr = new int[T+1];
        for(int i=1;i<T+1;i++)arr[i] = Integer.parseInt(br.readLine());
        for(int i=1;i<T+1;i++){

            boolean flag = true;

            for(int j=0;j<W+1;j++){
                //안움직
                if(j==0){
                    if(arr[i]==1)dp[i][j] = dp[i-1][j]+1;
                    else dp[i][j] = dp[i-1][j];
                    continue;
                }
                //움직
                int pos = 1;
                if(flag) pos = 2;
                //움직여서 같으면 1.그 전초에 지금 움직임 +1이랑, 2.그 전초에 그 전 움직임 비교
                if(arr[i]==pos) dp[i][j] = Math.max(dp[i-1][j]+1,dp[i-1][j-1]);
                //움직여서 다르면 1.그 전초에 그 전 움직임 +1이랑, 2. 그 전초에 현재 움직임 비교
                else dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]);
                flag = !flag; //와리가리
            }
        }
        System.out.println(dp[T][W]);
    }
}
