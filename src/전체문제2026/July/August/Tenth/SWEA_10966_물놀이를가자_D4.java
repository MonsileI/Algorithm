package 전체문제2026.July.August.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_10966_물놀이를가자_D4 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            Queue<int[]> q= new ArrayDeque<>();
            visited = new boolean[N][M];
            for(int i=0;i<N;i++) {
                map[i] = br.readLine().toCharArray();
                for(int j=0;j<M;j++){
                    if(map[i][j]=='W'){
                        q.offer(new int[]{i,j,0});
                        visited[i][j] = true;
                    }
                }
            }

            int answer = 0;
            while(!q.isEmpty()){
                int[]c = q.poll();
                int i = c[0]; int j = c[1];int cnt = c[2];
                answer += cnt;
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                    if(visited[ni][nj]) continue;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
            sb.append("#"+t+" "+answer+"\n");

        }
        System.out.println(sb.toString());
    }
}
