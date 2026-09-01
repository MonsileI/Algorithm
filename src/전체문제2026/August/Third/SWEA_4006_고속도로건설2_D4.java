package 전체문제2026.August.Third;

import java.util.*;
import java.io.*;
public class SWEA_4006_고속도로건설2_D4 {
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from  = Integer.parseInt(st.nextToken());
                int to  = Integer.parseInt(st.nextToken());
                int weight  = Integer.parseInt(st.nextToken());
                pq.offer(new Node(from,to,weight));
            }
            parent = new int[N+1];
            for(int i=1;i<=N;i++)parent[i] = i;
            int cnt = 0;
            int answer = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(find(cur.from)!=find(cur.to)){
                    union(cur.from,cur.to);
                    answer += cur.weight;
                    cnt++;
                }
                if(cnt==N-1) break;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    static int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
}
