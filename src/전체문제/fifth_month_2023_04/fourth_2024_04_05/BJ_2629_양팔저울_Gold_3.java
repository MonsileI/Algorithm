package 전체문제.fifth_month_2023_04.fourth_2024_04_05;

import java.util.*;
import java.io.*;
public class BJ_2629_양팔저울_Gold_3 {
    static int []arr;
    static int N;
    static boolean [][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        dp = new boolean[31][15001];
        find(0,0);
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>15000) {
                sb.append("N ");
                continue;
            }
            sb.append(dp[N][num] ? "Y " : "N ");
        }
        System.out.println(sb.toString());
    }
    static void find(int idx, int sum){
        if(dp[idx][sum]) return;
        dp[idx][sum] = true;
        if(idx==N) return;

        find(idx+1,sum+arr[idx]);
        find(idx+1,sum);
        find(idx+1,Math.abs(sum-arr[idx]));

    }

}
