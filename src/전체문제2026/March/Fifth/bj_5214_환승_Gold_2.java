package 전체문제2026.March.Fifth;

import java.util.*;
import java.io.*;
public class bj_5214_환승_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dist = new int[N+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist,INF);
        dist[1] = 1;
        boolean [][] isExist = new boolean[N+1][M];
        int [][]hyper = new int[M][K];
        boolean []visited = new boolean[M];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            boolean flag = false;
            for(int j=0;j<K;j++){
                hyper[i][j] = Integer.parseInt(st.nextToken());
                if(hyper[i][j]==1) {
                    flag = true;
                }
                isExist[hyper[i][j]][i] = true;
            }
            if(flag){
                visited[i] = true;
                for(int j=0;j<K;j++){
                    if(hyper[i][j]==1) continue;
                    if(dist[hyper[i][j]]==2) continue;
                    dist[hyper[i][j]] = 2;
                    q.offer(hyper[i][j]);
                }
            }
        }
        int cnt = 2;
        OuterLoop:
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;
            for(int t=0;t<size;t++){
                int node = q.poll();
                if(node==N) {
                    break OuterLoop;
                }
                for(int i=0;i<M;i++){
                    if(!isExist[node][i]) continue;
                    if(visited[i]) continue;
                    for(int j=0;j<K;j++){
                        if(dist[hyper[i][j]] != INF) continue;
                        dist[hyper[i][j]] = cnt;
                        q.offer(hyper[i][j]);
                    }
                }
            }
        }
        System.out.println(dist[N]==INF ? -1 : dist[N]);
    }
}
