package 전체문제2026.May.Seventh;
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
    static int N;
    static int INF = 987654321;
    static List<List<Node>> list;
    public static void main(String[] args) {
        int n = 6;
        int s=  4;
        int a = 6;
        int b = 2;
        int[][]fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n,s,a,b,fares));
    }
    static  int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int [] vertax : fares){
            int from = vertax[0];
            int to = vertax[1];
            int weight = vertax[2];
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        int[]sDist = dijk(s);
        int[]aDist = dijk(a);
        int[]bDist = dijk(b);
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++){
            if(sDist[i]==INF || aDist[i]==INF || bDist[i]==INF) continue;
            answer = Math.min(answer,(sDist[i]+aDist[i]+bDist[i]));
        }
        return answer;
    }
    static int[] dijk(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = cur.to;
            int weight = cur.weight;
            if(dist[to] < weight) continue;
            for(Node next : list.get(to)){
                if(dist[next.to] > dist[to] + next.weight){
                    dist[next.to] = dist[to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
         }
        return dist;
    }
}
