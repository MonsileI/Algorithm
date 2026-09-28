package 전체문제2026.September.Twelfth;

import java.util.*;

public class PR_합승택시요금_Level_3 {
    
    static class Node implements Comparable<Node>{
        int to; int weight;


        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    
    public static void main(String[] args) {
        int n = 6;
        int s= 4;
        int a =5;
        int b =6;
        int[][]fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        System.out.println(solution(n,s,a,b,fares));
    }
    static List<List<Node>> list;
    static int INF = 100000007;
    static int N;

    static int solution(int n, int s, int a, int b, int[][] fares) {
        N =n;
        list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int [] edge : fares){
            int from= edge[0];
            int to= edge[1];
            int weight= edge[2];
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        int [] distA = dijk(a);
        int [] distB = dijk(b);
        int [] distS = dijk(s);

        int answer = INF;
        for(int i =1;i<=N;i++){
            if(distA[i]==INF || distB[i]==INF || distS[i]==INF) continue;
            answer = Math.min(answer,distA[i] + distB[i] + distS[i]);
        }

        return answer;
    }
    static int[] dijk(int node){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[node] = 0;
        pq.offer(new Node(node,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to] < cur.weight) continue;
            for(Node next : list.get(cur.to)){
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
