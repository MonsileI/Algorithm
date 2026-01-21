package 전체문제2026.January.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_10942_팰린드롬_Gold_4 {
    static int N;
    static boolean[][]dp;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new boolean[N+1][N+1];
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++)  arr[i] = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(0<TC){

            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean flag = check(s,e);
            sb.append(flag ? "1" : "0");
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
    static boolean check(int L,int R){
        if(L>=R) return true;
        if(dp[L][R]) return true;
        if(arr[L]==arr[R]) return dp[L][R] = check(L+1,R-1);
        return false;
    }
}
