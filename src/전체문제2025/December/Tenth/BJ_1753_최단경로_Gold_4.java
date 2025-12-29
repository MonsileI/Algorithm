package 전체문제2025.December.Tenth;
import java.util.*;
import java.io.*;
public class BJ_1753_최단경로_Gold_4  {
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
    static List<List<Node>> list;
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }

        int[]dist = dijk(N,S);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(dist[i]==INF) sb.append("INF");
            else sb.append(dist[i]);
            if(i!=N) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[] dijk(int N,int S){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[S] = 0;
        pq.offer(new Node(S,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to] < cur.weight) continue;
            for(Node next : list.get(cur.to)){
                if(dist[next.to] > cur.weight + next.weight){
                    dist[next.to] = cur.weight + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
