package 그래프이론.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2211_네트워크복구_Gold_2 {
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
    static int[]path;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        path = new int[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        int[]dist = dijk(1);
        StringBuilder sb= new StringBuilder();
        sb.append(N-1+"\n");
        for(int i=2;i<N+1;i++) sb.append(path[i]+" "+i+"\n");
        System.out.println(sb.toString());
    }
    static int[] dijk(int start){
        int []dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    path[next.to]=now.to;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }

        return dist;
    }
}
