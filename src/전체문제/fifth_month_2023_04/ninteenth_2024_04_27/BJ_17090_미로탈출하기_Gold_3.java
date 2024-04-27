package 전체문제.fifth_month_2023_04.ninteenth_2024_04_27;

import java.util.*;
import java.io.*;
public class BJ_17090_미로탈출하기_Gold_3 {
    static int N;
    static int M;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean [][] visited;
    static boolean[][] subVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        //순환지점확인
        visited=  new boolean[N][M];
        subVisited=  new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    subVisited[i][j] = true;
                    int d = change(i,j);
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(!visited[ni][nj]) {
                        subVisited[ni][nj] = true;
                        dfs(ni, nj);
                        subVisited[ni][nj] = false;
                    }else visited[i][j] = true;
                    subVisited[i][j] = false;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }
    static int change(int i,int j){
        if(map[i][j]=='U') return 0;
        if(map[i][j]=='R') return 1;
        if(map[i][j]=='D') return 2;
        return 3;
    }
    static void dfs(int i,int j){
        int d = change(i,j);
        int ni = i + move[d][0]; int nj = j + move[d][1];
        if(ni<0||nj<0||N-1<ni||M-1<nj) return;

        if(subVisited[ni][nj]){
            for(int y=0;y<N;y++){
                for(int x=0;x<M;x++){
                    if(subVisited[y][x]) visited[y][x] = true;
                }
            }
            return;
        }
        subVisited[ni][nj] = true;
        dfs(ni,nj);
        subVisited[ni][nj] = false;
    }
}
