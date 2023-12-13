package 복합알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1260_DFS와BFS_Silver_2_DFS_BFS {
    static int N,M;
    static boolean[]visited;
    static StringBuilder sb;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()); //시작 정점
        list  = new ArrayList<>();
        sb = new StringBuilder();
        visited = new boolean[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1;i<N+1;i++) Collections.sort(list.get(i));


        visited[S] = true;
        dfs(S);
        visited = new boolean[N+1];
        sb.append("\n");

        visited[S] = true;
        bfs(S);
        System.out.println(sb.toString());
    }
    static void bfs(int start){
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node+" ");
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    static void dfs(int node){
        sb.append(node+" ");
        for(int next : list.get(node)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
