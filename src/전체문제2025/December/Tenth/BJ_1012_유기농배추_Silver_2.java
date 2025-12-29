package 전체문제2025.December.Tenth;

import java.util.*;
import java.io.*;
public class BJ_1012_유기농배추_Silver_2  {
    static int N,M;
    static int [][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st =null;

        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int t=0;t<W;t++){
                st= new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        visited[i][j] = true;
                        cnt++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(cnt+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
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
