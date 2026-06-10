package 전체문제2026.June.Sixth;

import java.util.*;
import java.io.*;
public class SWEA_하나로_D4 {
    static class Node implements Comparable<Node>{
        int from; int to; double weight;

        public Node(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;

        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(weight,o.weight);
        }

    }
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            long[][]arr = new long[N+1][2];
            parent = new int[N+1];
            for(int i=1;i<N+1;i++)parent[i] = i;
            for(int i=0;i<2;i++){
                st=  new StringTokenizer(br.readLine()," ");
                for(int j=1;j<N+1;j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            double E = Double.parseDouble(br.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    long diffI = Math.abs(arr[i][0] - arr[j][0]);
                    long diffJ = Math.abs(arr[i][1] - arr[j][1]);
                    double diff = E * ((diffI*diffI) + (diffJ*diffJ));
                    pq.offer(new Node(i,j,diff));
                }
            }
            int cnt = 0;
            double answer = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int rootA = find(cur.from);
                int rootB = find(cur.to);
                if(rootA!=rootB){
                    union(cur.from,cur.to);
                    cnt++;
                    answer += cur.weight;
                }
                if(cnt==N-1) break;
            }
            sb.append("#"+t+" "+Math.round(answer)+"\n");

        }
        System.out.println(sb.toString());
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parent[rootB] = rootA;
        else parent[rootA]= rootB;
    }
    static int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }
}
