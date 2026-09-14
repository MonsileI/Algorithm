package 전체문제2026.September.Sixth;

import java.util.*;
import java.io.*;
public class GR_주차시스템_D3 {
    static int N,M;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //0 +1 -> 2 -2
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j]!=1){
                    visited[i][j] = true;
                    int sum = bfs(i,j);
                    answer = Math.max(answer,sum);
                }
            }
        }
        System.out.println(answer);
    }
    static int bfs(int y,int x){
        int cnt = map[y][x]==0 ? 1 : -2;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj )continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==1) continue;
                if(map[ni][nj]==0) cnt++;
                else cnt -= 2;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
        }
        return cnt;
    }
}