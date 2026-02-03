package 전체문제2026.February.Second;

import java.util.*;
import java.io.*;
public class BJ_20162_간식파티_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int[]dp = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = dp[i] = Integer.parseInt(br.readLine());
        }
        int max = arr[0];
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
