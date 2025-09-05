package 전체문제.twleveth_month_2025_04.first_25_03_28;


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
            return this.weight - o.weight;
        }
    }

    static List<List<Node>> list;

    static int MAX_VALUE = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }

        int[]dist = dijk(start);
        StringBuilder sb=  new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(dist[i] == MAX_VALUE){
                sb.append("INF");
            }else{
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[] dijk(int start) {

        int[] dist = new int[N + 1];

        Arrays.fill(dist, MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.weight > dist[now.to]) continue;

            for (Node next : list.get(now.to)) {
                if (dist[next.to] > dist[now.to] + next.weight) {
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }

        }
    return dist;
    }
}
