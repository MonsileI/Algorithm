package 전체문제2026.May.Fifth;

import java.util.*;

public class PR_섬연결하기_Level_3 {
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
    static int N;
    public static void main(String[] args) {
        int n = 4;
        int[][]costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        System.out.println(solution(n,costs));
    }
    static int solution(int n, int[][] costs) {
        int answer = 0;
        N = n;
        parents = new int[N+1];
        for(int i=1;i<N+1;i++) parents[i] = i;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<costs.length;i++){
            pq.offer(new Node(costs[i][0],costs[i][1],costs[i][2]));
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int from = cur.from; int to = cur.to; int weight = cur.weight;
            if(find(from)!=find(to)){
                union(from,to);
                answer += weight;
                cnt++;
            }
            if(cnt==N-1) break;
        }
        return answer;
    }

    static int find(int node){
        if(parents[node]==node) return node;
        return parents[node] = find(parents[node]);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
}
