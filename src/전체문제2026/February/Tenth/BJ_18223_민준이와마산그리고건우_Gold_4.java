package 전체문제2026.February.Tenth;

import java.util.*;
import java.io.*;
public class BJ_18223_민준이와마산그리고건우_Gold_4 {

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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Geunwoo = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        int[] sToE = dijk(1);
        int[] sToG = dijk(1);
        int[] gToE = dijk(Geunwoo);
        if(sToE[N]==sToG[Geunwoo]+gToE[N]) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");

    }
    static int[] dijk(int start){
        PriorityQueue<Node>pq=new PriorityQueue<>();
        int[]dist = new int[N+1];
        int MAX = Integer.MAX_VALUE;
        Arrays.fill(dist,MAX);
        dist[start] = 0;
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
