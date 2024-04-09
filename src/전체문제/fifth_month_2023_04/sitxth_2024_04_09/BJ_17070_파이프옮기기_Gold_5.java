package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_17070_파이프옮기기_Gold_5 {
    static int N;
    static int [][]dp;
    static int [][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);
        System.out.println(dp[N-1][N-1]);
    }
    static void dfs(int i,int j,int s){
        if(N-1<i||N-1<j) return;
        if(map[i][j]==1) return;
        //가로면 대각선으로 가거나 가로로 이동 가능
        if(s==0){ //가로
            dfs(i,j+1,0);
            dfs(i+1,j+1,2);
        }
        //세로면 대각선으로 가거나 세로로 이동 가능
        if(s==1){ //세로
            dfs(i+1,j,1);
            dfs(i+1,j+1,2);
        }
        //대각선밀기 + 가로 + 세로
        if(s==2){ //대각선
           if(map[i-1][j]==1||map[i][j-1]==1)return;
           dfs(i,j+1,0);
           dfs(i+1,j,1);
           dfs(i+1,j+1,2);
        }
        dp[i][j]++;
    }
}
