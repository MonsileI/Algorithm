package 전체문제2026.February.Sixth;

import java.util.*;
import java.io.*;
public class BJ_11724_연결요소의개수_Silver_2 {
    static boolean[]visited;
    static List<List<Integer>> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited= new boolean[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a=  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int cnt =0;
        for(int i=1;i<N+1;i++){
            if(!visited[i]){
                visited[i] = true;
                cnt++;
                bfs(i);
            }
        }
        System.out.println(cnt);
    }
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node =q.poll();
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
