package 전체문제.thirteenth_month_2025_06.first_25_06_21;

import java.util.*;
import java.io.*;
public class BJ_1012_유기농배추_Silver_2  {

    static int [] di = {-1,0,1,0};
    static int [] dj = {0,1,0,-1};
    static boolean[][]visited;
    static int[][]map;

    static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i=0;i<C;i++){
                st = new StringTokenizer(br.readLine()," ");
                int bj = Integer.parseInt(st.nextToken());
                int bi = Integer.parseInt(st.nextToken());
                map[bi][bj] = 1;
            }
            int answer = run();
            sb.append(answer+"\n");
            TC--;
            if(TC==0) break;
        }
        System.out.println(sb.toString());
    }

    static void bfs(int i,int j){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int ci = c[0]; int cj= c[1];
            for(int d=0;d<4;d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj] == 1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj});
                }

            }
        }
    }
    static int run(){

        visited = new boolean[N][M];

        int answer = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    answer++;
                    bfs(i,j);
                }
            }
        }
    return answer;

    }
}
