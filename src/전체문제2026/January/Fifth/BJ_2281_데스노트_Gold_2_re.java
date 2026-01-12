package 전체문제2026.January.Fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2281_데스노트_Gold_2_re {
    static int N, M;
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        dp = new int[2000][2000]; //인덱스, 남은 자리
        for(int i=0;i<2000;i++) Arrays.fill(dp[i],-1);
        System.out.println(dfs(0,0));
    }
    static int dfs(int idx,int cnt){

        if(idx==N) return 0;

        if(dp[idx][cnt] != -1) return dp[idx][cnt];

        int spare = M - (cnt-1);
        int result = dfs(idx+1,arr[idx]+1) + (int)Math.pow(spare,2);
        if(arr[idx] + cnt <=M ){
            result = Math.min(result, dfs(idx+1,cnt+arr[idx]+1));
        }
        return dp[idx][cnt] = result;
    }
}