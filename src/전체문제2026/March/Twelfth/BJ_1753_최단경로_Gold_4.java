package 전체문제2026.March.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_1753_최단경로_Gold_4 {
    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight -o.weight;
        }
    }
    static List<List<Node>> list;
    static int N;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
        }
        int[]dist = dijk(S);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(dist[i]==INF ? "INF" : dist[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    static int[] dijk(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight = cur.weight;
            if(dist[node] < weight) continue;
            for(Node next : list.get(node)){
                if(dist[next.to] > dist[node] + next.weight){
                    dist[next.to] = dist[node] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
         }
        return dist;
    }
}
