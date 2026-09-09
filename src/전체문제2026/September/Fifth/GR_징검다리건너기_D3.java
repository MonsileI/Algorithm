package 전체문제2026.September.Fifth;

import java.util.*;
import java.io.*;
public class GR_징검다리건너기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+2];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        if(N<3){
            System.out.println(0);
        }else{
            int[]dp = new int[N+2];
            for(int i=1;i<=3;i++) dp[i] = arr[i];
            for(int i=3;i<=N+1;i++){
                dp[i] = Math.min(dp[i-1],Math.min(dp[i-2],dp[i-3])) + arr[i];
            }
            System.out.println(dp[N+1]);
        }
    }
}
