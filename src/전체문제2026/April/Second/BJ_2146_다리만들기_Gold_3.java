package 전체문제2026.April.Second;

import java.util.*;
import java.io.*;
public class BJ_2146_다리만들기_Gold_3 {
    static int N;
    static int [][]map;
    static boolean[][]visited;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        StringTokenizer st = null;
        visited=  new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]==1){
                    visited[i][j] = true;
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        Queue<int[]> tmpQ = new ArrayDeque<>();
        tmpQ.offer(new int[]{y,x,0});
        boolean[][]tmpVisited=  new boolean[N][N];
        tmpVisited[y][x] = true;
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0];int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==0) continue;
                visited[ni][nj] = true;
                tmpVisited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
                tmpQ.offer(new int[]{ni,nj,0});
            }
        }
        int min = Integer.MAX_VALUE;
        while(!tmpQ.isEmpty()){
            int[]c = tmpQ.poll();
            int i = c[0];int j = c[1]; int cnt = c[2];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(tmpVisited[ni][nj]) continue;
                tmpVisited[ni][nj] = true;
                if(map[ni][nj]==1){
                    min = Math.min(min,cnt);
                }else{
                    tmpQ.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        answer = Math.min(answer,min);
    }
}
