package 전체문제.fifth_month_2023_04.sixteenth_2024_04_24;

import java.util.*;
import java.io.*;
public class BJ_14500_테트로미노_Gold_4 {
    static int N,M;
    static int ans;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited= new boolean[N][M];
        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = true;
                dfs(i,j,map[i][j],1);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);
    }
    static void dfs(int i,int j, int sum,int depth){
        if(depth==4){
            ans = Math.max(ans,sum);
            return;
        }
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(!visited[ni][nj]){
                visited[ni][nj]= true;
                dfs(ni,nj,sum+map[ni][nj],depth+1);
                if(depth==2) dfs(i,j,sum+map[ni][nj],depth+1);
                visited[ni][nj] = false;

            }
        }

    }
}
