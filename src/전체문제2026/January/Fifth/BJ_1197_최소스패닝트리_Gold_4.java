package 전체문제2026.January.Fifth;

import java.util.*;
import java.io.*;
public class BJ_1197_최소스패닝트리_Gold_4  {

    static class Node implements Comparable<Node>{
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
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
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        pq = new PriorityQueue<>();
        for(int i=1;i<N+1;i++) parent[i] = i;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b,w));
        }
        int cnt = 0;
        int answer = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int a = find(cur.from); int b = find(cur.to);
            if(a!=b){
                union(a,b);
                cnt++;
                answer += cur.weight;
            }
            if(cnt==N-1) break;
        }
        System.out.println(answer);
    }
    static int find(int node){
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA< rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}
