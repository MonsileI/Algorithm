package 전체문제.tenth_month_2024_11.first_2024_11_22;

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
            return weight - o.weight;
        }
    }
    static int N;
    static int INF = 987654321;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }
        int[]dist = dijk(start);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(dist[i]==INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[] dijk(int start){

        int[]dist = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist,INF);
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node c = pq.poll();
            if(c.weight > dist[c.to]) continue;
            for(Node next : list.get(c.to)){
                if(dist[next.to] > dist[c.to] + next.weight){
                    dist[next.to] = dist[c.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
