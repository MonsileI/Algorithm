package 전체문제2026.July.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_7465_창용마을무리의개수_D4 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<=N;i++) list.add(new ArrayList<>());
            visited = new boolean[N+1];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            int answer = 0;
            for(int i=1;i<=N;i++){
                if(!visited[i]){
                    answer++;
                    visited[i] = true;
                    bfs(i);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());

    }
    static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            int c=  q.poll();
            for(int next : list.get(c)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
