package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_21938_영상처리_Silver_2 {
    static boolean[][]visited;
    static int N,M;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                int num = 0;
                for(int l=0;l<3;l++) {
                    num += Integer.parseInt(st.nextToken());
                }
                map[i][j] = num/3;
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(K<=map[i][j]){
                    map[i][j] = 255;
                }else{
                    map[i][j] = 0;
                }
            }
        }
        int cnt = 0;
        visited= new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==255 && !visited[i][j]){
                    cnt++;
                    visited[i][j] = true;
                    bfs(i,j);
                }
            }
        }
        System.out.println(cnt);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==0) continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
        }
    }
}
