package 전체문제2026.July.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_1949_등산로조성 {
    static int N,K;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            int max = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,map[i][j]);
                }
            }
            answer = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(max==map[i][j]){
                        visited[i][j] = true;
                        dfs(i,j,1,0);
                        visited[i][j] = false;
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int i,int j,int cnt,int state){
        answer = Math.max(answer,cnt);
        for(int d=0;d<4;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
            if(visited[ni][nj]) continue;
            if(map[i][j] > map[ni][nj]){
                visited[ni][nj] = true;
                dfs(ni,nj,cnt+1,state);
                visited[ni][nj] = false;
            }else{
                if(state==1) continue;
                int diff = map[ni][nj] - map[i][j];
                if(diff>=K) continue;
                int tmp = map[ni][nj];
                map[ni][nj] = map[i][j]-1;
                visited[ni][nj] = true;
                dfs(ni,nj,cnt+1,1);
                map[ni][nj] = tmp;
                visited[ni][nj] = false;
            }
        }
    }
}
