package 전체문제2026.August.Ninteenth;

import java.util.*;
import java.io.*;
public class GR_대체경로_D3 {
    static int N,S,E;
    static List<List<Integer>> list;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1;i<=N;i++){
            if(i==S || i==E) {
                sb.append(-1+"\n");
                continue;
            }
            int answer = bfs(i);
            sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static int bfs(int stop){
        Queue<int[]> q= new ArrayDeque<>();
        visited=  new boolean[N+1];
        visited[S]= true;
        q.offer(new int[]{S,1});
        int result = -1;
        while(!q.isEmpty()){
            int []cur = q.poll();
            int node= cur[0]; int cnt = cur[1];
            if(node==E){
                result = cnt;
                break;
            }
            for(int next : list.get(node)){
                if(next==stop) continue;
                if(visited[next]) continue;
                visited[next] = true;
                q.offer(new int[]{next,cnt+1});
            }
        }
        return result;
    }
}
