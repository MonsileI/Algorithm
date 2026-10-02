package 전체문제2026.October.First;

import java.util.*;
import java.io.*;
public class GR_연합_D2 {
    static int N;
    static boolean[]visited;
    static boolean[][]isConnected;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        isConnected = new boolean[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            isConnected[a][b] = true;
        }
        visited=  new boolean[N+1];
        int answer = 0;
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                answer++;
                bfs(i);
            }
        }
        System.out.println(answer);
    }
    static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            int c = q.poll();
            for(int next : list.get(c)){
                if(!visited[next] && isConnected[next][c]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
