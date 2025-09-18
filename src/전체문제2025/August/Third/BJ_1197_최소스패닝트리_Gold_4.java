package 전체문제2025.August.Third;

import java.util.*;
import java.io.*;
public class  BJ_1197_최소스패닝트리_Gold_4  {

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;

        public Node(int from,int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Node(from,to,weight));
            pq.offer(new Node(to,from,weight));
        }
        int sum = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from) != find(now.to)){
                union(now.from, now.to);
                sum += now.weight;
            }

        }
        System.out.println(sum);
    }
    static int find(int node){
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA < rootB) {
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }

    }

}
