package DP.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ST_징검다리_Level_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[]arr = new int[N];
        int[]dp = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int max = 1;
        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
