package 전체문제.fourth_month_2024_03.second_2024_03_04;
import java.util.*;
import java.io.*;
public class BJ_6497_전력난_Gold_4 {
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
    static int[]parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        PriorityQueue<Node> pq = null;
        int sum  =0;
        int M = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            st =new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 &&M==0) break;
            pq = new PriorityQueue<>();
            sum = 0;
            parents = new int[N];
            for(int i=0;i<N;i++)parents[i] = i;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                sum += weight;
                pq.offer(new Node(from, to, weight));
            }
            int cnt=0;
            int comp = 0;
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(find(now.from)!=find(now.to)){
                    cnt++;
                    union(now.from,now.to);
                    comp += now.weight;
                }
                if(cnt==N-1) break;
            }
            sb.append(sum-comp+"\n");
        }
        System.out.println(sb.toString());
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB =find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num]=find(parents[num]);
    }
}
