package 전체문제2026.February.Tenth;

import java.util.*;
import java.io.*;
public class BJ_11779_최소비용구하기2_Gold_3 {
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
    static int[]prev;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st = null;
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
        }
        prev = new int[N+1];
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int minCost = dijk(start,end);
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while(cur!=0){
            path.add(cur);
            cur = prev[cur];
        }
        StringBuilder sb= new StringBuilder();
        sb.append(minCost+"\n");
        int len = path.size();
        sb.append(len+"\n");
        for(int i = len-1 ; -1<i;i--){
            sb.append(path.get(i)+" ");
        }
        System.out.println(sb.toString());
    }
    static int dijk(int start,int end){
        int[]dist=  new int[N+1];
        int MAX = Integer.MAX_VALUE;
        Arrays.fill(dist,MAX);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight = cur.weight;
            if(dist[node] < weight) continue;
            for(Node next : list.get(node)){
                if(dist[next.to] > dist[node] + next.weight){
                    dist[next.to] = dist[node] + next.weight;
                    prev[next.to] = node;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist[end];
    }
}
