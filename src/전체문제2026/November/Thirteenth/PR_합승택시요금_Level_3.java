package 전체문제2026.November.Thirteenth;

import java.util.*;

public class PR_합승택시요금_Level_3 {
    static class Node implements Comparable<Node>{
        int to; long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(weight,o.weight);
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][]fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        System.out.println(solution(n,s,a,b,fares));
    }
    static List<List<Node>> list;
    static int N;
    static int INF = Integer.MAX_VALUE;

    static int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<=n;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int firNode = fares[i][0];
            int secNode = fares[i][1];
            int weight = fares[i][2];
            list.get(firNode).add(new Node(secNode,weight));
            list.get(secNode).add(new Node(firNode,weight));
        }
        long[] aArr = dijk(a);
        long[] bArr = dijk(b);
        long[] sArr = dijk(s);
        long answer = INF;
        for(int i=1;i<=n;i++){
            if(aArr[i]==INF || bArr[i] == INF || sArr[i] == INF) continue;
            answer = Math.min(answer,aArr[i]+bArr[i]+sArr[i]);
        }
        return (int)answer;
    }
    static long[] dijk(int start){
        long[]dist = new long[N+1];
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
