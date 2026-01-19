package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_2573_빙산_Gold_4 {
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
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
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            // 빙산 개수 확인
            visited = new boolean[N][M];
            int cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]!=0 && !visited[i][j]){
                        visited[i][j] = true;
                        cnt++;
                        bfs(i,j);
                    }
                }
            }
            if(cnt==0){
                answer = 0;
                break;
            }
            if(1<cnt){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            int zero = 0;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==0){
                    zero++;
                    continue;
                }
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
            map[i][j] -= zero;
            map[i][j] = Math.max(map[i][j],0);
        }
    }
}
