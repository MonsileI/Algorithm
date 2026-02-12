package 전체문제2026.February.Seventh;

import java.util.*;
import java.io.*;
public class BJ_10942_팰린드롬_Gold_4  {
    static int N;
    static int[]arr;
    static int[][]dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        dp = new int[N][N]; //0 -> 아직 모름 1-> 팰린드롬 -1 -> 팰린드롬 아님
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken())-1;
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++) dp[i][i] = 1; //자기 자신은 팰린드롬
        while(0<Q){

            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            sb.append(dp(start,end) == -1 ? 0 : 1);
            sb.append("\n");
            Q--;
        }
        System.out.println(sb.toString());

    }
    static int dp(int start,int end){
        if(end<=start) return 1;
        if(dp[start][end] !=0 )return dp[start][end];
        if(arr[start]!=arr[end]) return dp[start][end] = -1;
        return dp[start][end] = dp(start+1,end-1);
    }
}
