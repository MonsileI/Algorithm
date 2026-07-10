package 전체문제2026.July.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_1861_정사각형방_D4 {
    static int N;
    static int [][]map;
    static int [][]isVisited;
    static int answer;
    static int smallNode;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = 0;
            smallNode = 987654321;
            isVisited = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isVisited[i][j] == 0) {
                        dfs(i, j,i,j, 1);
                    }
                }
            }
            sb.append("#"+t+" "+smallNode+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int oi,int oj,int y,int x,int cnt){
        isVisited[y][x] = cnt;
        boolean flag = false;
        for(int d=0;d<4;d++){
            int ni = y + move[d][0];
            int nj = x + move[d][1];
            if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
            if((map[y][x]+1) == map[ni][nj] && isVisited[ni][nj] <= cnt){
                flag = true;
                dfs(oi,oj,ni,nj,cnt+1);
            }
        }
        if(!flag){
            if(answer<cnt){
                answer = cnt;
                smallNode = map[oi][oj];
            }else if(answer==cnt){
                smallNode = Math.min(smallNode,map[oi][oj]);
            }
        }
    }
}
