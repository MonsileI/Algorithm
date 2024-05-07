package 전체문제.sixth_month_2024_05.fourth_2024_05_04;

import java.util.*;
import java.io.*;
public class BJ_1103_게임_Gold_2 {
    static int ans;
    static boolean flag;
    static boolean[][]visited;
    static int N,M;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int [][]dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map  = new char[N][M];
        visited=  new boolean[N][M];
        dp = new int[N][M];
        visited[0][0] = true;
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        dfs(0,0,1);
        System.out.println(flag ? -1 : ans);
    }
    static void dfs(int y,int x,int cnt){
        if(flag) return;
        dp[y][x] = cnt;
        for(int d=0;d<4;d++){
            int gop = Integer.parseInt(map[y][x]+"");
            int ni = y + move[d][0] * gop;
            int nj = x + move[d][1] * gop;
            if(ni<0||nj<0||N-1<ni||M-1<nj){
                ans = Math.max(ans,cnt);
                continue;
            }
            if(map[ni][nj]=='H') {
                ans = Math.max(ans,cnt);
                continue;
            }
            if(visited[ni][nj]){
                flag = true;
                return;
            }
            if(cnt<dp[ni][nj]) continue;
            visited[ni][nj] = true;
            dfs(ni,nj,cnt+1);
            visited[ni][nj] = false;
        }
    }
}
