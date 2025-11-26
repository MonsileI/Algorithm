package 전체문제2025.November.Ninth;

import java.util.*;
import java.io.*;
public class BJ_1922_네트워크연결_Gold_4 {

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
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        parent = new int[N+1];
        for(int i=0;i<N+1;i++) parent[i] = i;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b,w));
        }
        int sum  = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(find(cur.from) != find(cur.to)){
                union(cur.from,cur.to);
                sum += cur.weight;
            }
        }
        System.out.println(sum);
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
    }
}
