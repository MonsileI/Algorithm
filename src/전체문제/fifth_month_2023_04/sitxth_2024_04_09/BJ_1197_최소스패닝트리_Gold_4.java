package 전체문제.fifth_month_2023_04.sitxth_2024_04_09;

import java.util.*;
import java.io.*;
public class BJ_1197_최소스패닝트리_Gold_4 {
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
    static int[]parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b,w));
        }
        int cnt = 0;
        int answer = 0 ;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(find(now.from)!=find(now.to)){
                union(now.from,now.to);
                cnt++;
                answer += now.weight;
            }
            if(cnt==N-1) break;
        }
        System.out.println(answer);
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
