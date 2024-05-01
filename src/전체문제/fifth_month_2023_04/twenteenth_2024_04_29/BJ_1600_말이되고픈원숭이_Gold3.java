package 전체문제.fifth_month_2023_04.twenteenth_2024_04_29;

import java.util.*;
import java.io.*;
public class BJ_1600_말이되고픈원숭이_Gold3 {
    static int N,M,K;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]horse = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    static boolean[][][]visited;
    static int[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited=  new boolean[N][M][K+1];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q= new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2]; int k = c[3];
            if(i==N-1 && j==M-1) return cnt;
            for(int d=0;d<8;d++){
                int ni = i + horse[d][0];
                int nj = j + horse[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==1) continue;
                if(k==K) continue;
                if(!visited[ni][nj][k+1]){
                    visited[ni][nj][k+1] = true;
                    q.offer(new int[]{ni,nj,cnt+1,k+1});
                }
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==1) continue;
                if(!visited[ni][nj][k]){
                    visited[ni][nj][k] = true;
                    q.offer(new int[]{ni,nj,cnt+1,k});
                }
            }
        }

        return -1;
    }
}
