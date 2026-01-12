package 전체문제2026.January.Fifth;
import java.util.*;
import java.io.*;
public class BJ_5557_1학년_Gold_5  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
        long[][]dp = new long[N+1][21];
        dp[1][arr[1]]++;
        for(int i=1;i<N;i++){
           for(int j=0;j<21;j++){
               if(dp[i-1][j]!=0){
                   if(j+arr[i]<21) dp[i][j+arr[i]] += dp[i-1][j];
                   if(-1<j-arr[i]) dp[i][j-arr[i]] += dp[i-1][j];
               }
           }
        }

        System.out.println(dp[N-1][arr[N]]);
    }
}
