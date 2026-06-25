package 전체문제2026.June.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_1238_Contact_D4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int INF = 987654321;
        int TC = 10;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<101;i++) list.add(new ArrayList<>());
            int maxNode = 0;
            for(int i=0;i<M/2;i++){
                int a  = Integer.parseInt(st.nextToken());
                int b  = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                maxNode = Math.max(maxNode,Math.max(a,b));
            }
            int N = 101;
            int[]dist = new int[N];
            Arrays.fill(dist,INF);
            dist[S] = 0; //자기자신
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{S,0});
            while(!q.isEmpty()){
                int[]c = q.poll();
                int node = c[0]; int cnt = c[1];
                for(Integer next : list.get(node)){
                    if(dist[next] > cnt){
                        dist[next] = cnt+1;
                        q.offer(new int[]{next,cnt+1});
                    }
                }
            }
            int max = -1;
            int answer = 0;

            for(int i=1;i<=maxNode;i++){
                if(dist[i]==INF) continue;
                if(max<=dist[i]){
                    max = dist[i];
                    answer = i;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
