package 전체문제2026.June.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_3124_최소스패닝트리_D4 {
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
    static int[]parent;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            for(int i=1;i<N+1;i++)parent[i] = i;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int M = Integer.parseInt(st.nextToken());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.offer(new Node(a,b,w));
            }
            long sum  =0;
            int cnt = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int rootA = find(cur.from);
                int rootB = find(cur.to);
                if(rootA!=rootB){
                    union(cur.from,cur.to);
                    cnt++;
                    sum += cur.weight;
                }
                if(cnt==N-1) break;
            }
            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb.toString());
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
}
