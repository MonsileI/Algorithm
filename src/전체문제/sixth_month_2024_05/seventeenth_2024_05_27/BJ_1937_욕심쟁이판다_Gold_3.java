package 전체문제.sixth_month_2024_05.seventeenth_2024_05_27;


import java.util.*;
import java.io.*;
public class BJ_1937_욕심쟁이판다_Gold_3  {
    static int N;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[N][N];
        dp = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                answer = Math.max(answer,dfs(i,j));
            }
        }
        System.out.println(answer);
    }
    static int dfs(int i,int j){
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j] = 1;
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
            if(map[i][j]<map[ni][nj]) dp[i][j] = Math.max(dp[i][j],dfs(ni,nj)+1);
        }
        return dp[i][j];
    }
}