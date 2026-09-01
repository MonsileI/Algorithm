package 전체문제2026.September.First;

import java.util.*;
import java.io.*;
public class GR_영상처리_D3 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }
        int max = 0;
        int cnt  = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='#' && !visited[i][j]){
                    visited[i][j] = true;
                    cnt++;
                    max = Math.max(max,bfs(i,j));
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    static int bfs(int y,int x){
        int sum = 1;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]!='#') continue;
                visited[ni][nj] = true;
                sum++;
                q.offer(new int[]{ni,nj});
            }
        }
        return sum;
    }
}