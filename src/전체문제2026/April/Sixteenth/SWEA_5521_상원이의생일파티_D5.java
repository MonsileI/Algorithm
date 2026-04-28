package 전체문제2026.April.Sixteenth;

import java.util.*;
import java.io.*;
public class SWEA_5521_상원이의생일파티_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);
            }
            Queue<int[]> q= new ArrayDeque<>();
            boolean [] visited = new boolean[N+1];
            visited[1] = true;
            for(int node : list.get(1)){
                q.offer(new int[]{node,1});
                visited[node] = true;
            }
            int answer =0;
            while(!q.isEmpty()){
                int[]c = q.poll();
                int node = c[0];
                int depth = c[1];
                answer++;
                for(int next :list.get(node)){
                    if(!visited[next]){
                        visited[next] = true;
                        if(depth<2){
                            q.offer(new int[]{next,depth+1});
                        }
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
