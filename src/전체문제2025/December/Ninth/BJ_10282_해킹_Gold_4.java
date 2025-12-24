package 전체문제2025.December.Ninth;

import java.util.*;
import java.io.*;
public class BJ_10282_해킹_Gold_4  {
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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                //b가 감염되면 a도 감염
                list.get(b).add(new Node(a,w));
            }
            int[]dist = dijk(S,N);
            int cnt = 0;
            int max = 0;
            for(int i=1;i<N+1;i++){
                if(dist[i]!=987654321){
                    cnt++;
                    max = Math.max(max,dist[i]);
                }
            }
            sb.append(cnt+" "+max+"\n");
            TC--;
        }
        System.out.println(sb.toString());

    }
    static int[] dijk(int S,int N){
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to] < cur.weight) continue;
            for(Node next : list.get(cur.to)){
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
