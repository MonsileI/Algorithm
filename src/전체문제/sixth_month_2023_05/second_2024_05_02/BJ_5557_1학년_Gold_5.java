package 전체문제.sixth_month_2023_05.second_2024_05_02;

import java.util.*;
import java.io.*;
public class BJ_5557_1학년_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        long[][]dp = new long[N][21];
        dp[0][arr[0]] = 1;
        for(int i=1;i<N-1;i++){
            for(int j=0;j<21;j++){
                if(dp[i-1][j]!=0){
                    int plus = j + arr[i];
                    if(plus<21) dp[i][plus] += dp[i-1][j];
                    int minus = j - arr[i];
                    if(-1<minus) dp[i][minus] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-2][arr[N-1]]);
    }
}
