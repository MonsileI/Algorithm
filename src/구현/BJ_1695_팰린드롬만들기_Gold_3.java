package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1695_팰린드롬만들기_Gold_3 {
    static int[][]dp;
    static int[]arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        dp = new int[N][N];
        int L = 0 ;int R = N-1;
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        System.out.println(rec(L,R));
    }
    static int rec(int L, int R){
        if(L>R) return 0;
        if(dp[L][R]!=-1) return dp[L][R];
        if(arr[L]==arr[R]) dp[L][R] = rec(L+1,R-1);
        else dp[L][R] = Math.min(rec(L+1,R)+1,rec(L,R-1)+1);
        return dp[L][R];
    }
}
