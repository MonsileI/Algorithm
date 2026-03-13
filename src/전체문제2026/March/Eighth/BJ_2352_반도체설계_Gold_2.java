package 전체문제2026.March.Eighth;

import java.util.*;
import java.io.*;
public class BJ_2352_반도체설계_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]dp = new int[N+1];
        int max = 0;
        for(int i=1;i<N+1;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
