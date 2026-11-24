package 전체문제2026.November.Sixteenth;

import java.util.*;
import java.io.*;
public class BJ_4963_섬의개수_Silver_2 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int [][]move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            if(M==0) break;
            N = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited= new boolean[N][M];
            for(int i=0;i<N;i++){
                st= new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j]==1){
                        visited[i][j] = true;
                        answer++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1];
            for(int d=0;d<8;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
    }
}
