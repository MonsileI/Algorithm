package 전체문제2026.July.Twelfth;

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
    static int INF = 987654321;
    static List<List<Node>> list;
    static int N;

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][]fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n,s,a,b,fares));
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            list.get(fares[i][0]).add(new Node(fares[i][1],fares[i][2]));
            list.get(fares[i][1]).add(new Node(fares[i][0],fares[i][2]));
        }
        int [] distA = dijk(a);
        int [] distB = dijk(b);
        int [] distS = dijk(s);
        int answer = INF;
        for(int i=1;i<N+1;i++){
            if(distA[i]==INF || distB[i] == INF || distS[i] == INF) continue;
            answer = Math.min(answer,(distA[i]+distB[i]+distS[i]));
        }
        return answer;
    }
    static int[] dijk (int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
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
