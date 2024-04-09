package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

 import java.util.*;
 import java.io.*;
 public class BJ_2294_동전2_Gold_5 {
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         int N = Integer.parseInt(st.nextToken());
         int G = Integer.parseInt(st.nextToken());
         int[]arr = new int[N];
         for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
         int[]dp = new int[G+1];
         Arrays.fill(dp,987654321);
         dp[0] = 0;
         for(int i=0;i<N;i++){
             int money = arr[i];
             for(int j=money;j<G+1;j++){
                 dp[j] = Math.min(dp[j],dp[j-money]+1);
             }
         }
         System.out.println(dp[G]==987654321 ? -1 :dp[G]);
     }
 }
