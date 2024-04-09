package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

 import java.util.*;
 import java.io.*;
 public class BJ_2193_이친수_Silver_3 {
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(br.readLine());
         long[]dp = new long[N+1];
         if(N==1) System.out.println(1);
         else if(N==2) System.out.println(1);
         else{
             dp[1] = 1;
             dp[2] = 1;
             for(int i=3;i<N+1;i++) dp[i] = dp[i-1] + dp[i-2];
             System.out.println(dp[N]);
         }
     }
 }
