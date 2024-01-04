package 전체문제.first_month_2023_12.second_2023_12_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S  = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[]visited = new boolean[N+1];
        int[]dist = new int[N+1];
        int INF = 987654321;
        Arrays.fill(dist,INF);
        dist[S] = 0;
        pq.offer(new Node(S,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(dist[i]==INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
