package 전체문제.sixth_month_2024_05.seventh_2024_05_09;

import java.util.*;
import java.io.*;
public class BJ_17835_면접보는승범이네_Gold_2 {
    static class Node implements Comparable<Node>{
        int to; long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (weight - o.weight);
        }
    }

    static int N;
    static List<List<Node>> list;
    static PriorityQueue<Node> pq;
    static long[]dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(b).add(new Node(a,w));
        }
        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        dist= new long[N+1];

        Arrays.fill(dist,Long.MAX_VALUE);

        for(int i=0;i<K;i++){
            int num = Integer.parseInt(st.nextToken());
            pq.offer(new Node(num,0));
            dist[num] = 0;
        }
        dijk();
        long max = 0;
        for(int i=1;i<N+1;i++){
            max = Math.max(max,dist[i]);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(max==dist[i]){
                sb.append(i+"\n");
                break;
            }
        }
        sb.append(max+"\n");
        System.out.println(sb.toString());
    }
    static void dijk(){
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
    }
}
