package 전체문제2026.September.Ninth;

import java.util.*;
import java.io.*;
public class GR_심리적거리감_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int a=  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }
        boolean[]visited = new boolean[N+1];
        visited[K] = true;
        int[]dist = new int[N+1];
        Arrays.fill(dist,-1);
        dist[K] = 0;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{K,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int node = c[0]; int cnt = c[1];
            dist[node] = cnt;
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        int max = 0;
        int answer = -1;
        for(int i=1;i<=N;i++){
            if(i==K) continue;
            if(dist[i]==-1) continue;
            int diff = dist[i] + Math.abs(i-K);
            if(max<=diff){
                max = diff;
                answer = i;
            }
        }
        System.out.println(answer);

    }
}
