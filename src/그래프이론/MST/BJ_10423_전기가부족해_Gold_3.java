package 그래프이론.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10423_전기가부족해_Gold_3 {
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
    static int [] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int K = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine()," ");
        int origin = Integer.parseInt(st.nextToken());
        for(int i=1;i<K;i++){
            int num = Integer.parseInt(st.nextToken());
            parents[num] = origin;
        }
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Node(from,to,weight));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int f = find(now.from); int s = find(now.to);
            if(f!=s){
                ans += now.weight;
                union(f,s);
            }
        }
        System.out.println(ans);
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
}
