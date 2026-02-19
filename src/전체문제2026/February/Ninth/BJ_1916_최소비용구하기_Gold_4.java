package 전체문제2026.February.Ninth;

import com.sun.source.tree.NewArrayTree;

import java.util.*;
import java.io.*;
public class BJ_1916_최소비용구하기_Gold_4 {
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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        int MAX = 987654321;
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
        System.out.println(dist[end]==MAX ? -1 : dist[end]);
    }
}
