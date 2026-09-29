package 전체문제2026.September.Eleventh;

import java.util.*;
import java.io.*;
public class GR_동전줍기대회_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        long[]dp = new long[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        long answer = 0;
        dp[0] = arr[0];
        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);

    }
}
