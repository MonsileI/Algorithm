package 전체문제2026.November.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_19118_언덕길_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            int[]dp = new int[N];
            Arrays.fill(dp,1);
            int answer = 1;
            for(int i=1;i<N;i++){
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                answer = Math.max(answer,dp[i]);
            }
            sb.append("#"+t+" "+(N-answer)+"\n");
        }
        System.out.println(sb.toString());
    }
}
