package 전체문제.seven_month_2024_06.twelfth_2024_06_20;

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
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }
        int []dist = dijks(start);
        StringBuilder sb=  new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(dist[i]==987654321 ? "INF" : dist[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[] dijks(int start){
        int []dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to]<now.weight) continue;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }

}
