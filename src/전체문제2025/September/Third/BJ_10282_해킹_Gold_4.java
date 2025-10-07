package 전체문제2025.September.Third;

import java.util.*;
import java.io.*;
public class BJ_10282_해킹_Gold_4 {

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            List<List<Node>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            int[]dist = new int[N+1];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int A  = Integer.parseInt(st.nextToken());
                int B  = Integer.parseInt(st.nextToken());
                int W  = Integer.parseInt(st.nextToken());
                list.get(B).add(new Node(A,W));
            }
            int cnt = 0;
            int max = 0;
            int INF = 987654321;
            Arrays.fill(dist,INF);
            dist[S] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(S,0));
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(dist[node.to] < node.weight) continue;
                for(Node next : list.get(node.to)){
                    if(dist[next.to] > dist[node.to] + next.weight){
                        dist[next.to] = dist[node.to] + next.weight;
                        pq.offer(new Node(next.to,dist[next.to]));
                    }
                }
            }
            for(int i=1;i<N+1;i++){
                if(dist[i] != INF) {
                    max = Math.max(max, dist[i]);
                    cnt++;
                };
            }
            sb.append(cnt+" "+max+"\n");
        }
        System.out.println(sb.toString());
    }
}
