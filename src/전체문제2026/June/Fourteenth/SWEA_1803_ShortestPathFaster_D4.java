package 전체문제2026.June.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_1803_ShortestPathFaster_D4 {
    static class Node implements Comparable<Node>{
        int to; long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return Long.compare(weight , o.weight);
        }
    }
    static int N;
    static List<List<Node>> list;
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,w));
                list.get(b).add(new Node(a,w));
            }
            long[]dist = dijk(S);
            sb.append("#"+t+" "+dist[E]+"\n");
        }
        System.out.println(sb.toString());
    }
    static long[] dijk(int start){
        long[]dist = new long[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = cur.to; long weight = cur.weight;
            if(dist[to] < weight) continue;
            for(Node next : list.get(to)){
                if(dist[next.to] > dist[to] + next.weight){
                    dist[next.to] = dist[to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
