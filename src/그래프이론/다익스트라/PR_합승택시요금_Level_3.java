package 그래프이론.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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

    static List<List<Node>> list;
    static int N;
    static int INF = 987654321;
    static int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int node1 = fares[i][0];
            int node2 = fares[i][1];
            int w = fares[i][2];
            list.get(node1).add(new Node(node2,w));
            list.get(node2).add(new Node(node1,w));
        }
        int[]origin = dijks(s);
        int[]firDist = dijks(a);
        int[]secDist = dijks(b);
        int ans = INF;
        for(int i=1;i<N+1;i++){
            int o = origin[i];
            int fir = firDist[i];
            int sec = secDist[i];
            if(o==INF||fir==INF||sec==INF) continue;
            ans = Math.min(ans,(o+fir+sec));
        }
        return ans;
    }
    static int[] dijks(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        boolean[]visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to]>dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        /*Test Case
        int n = 6; int s = 4; int a = 6; int b = 2; int[][]fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int n = 7; int s = 3; int a = 4; int b = 1; int[][]fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        int n = 6; int s = 4; int a = 5; int b = 6; int[][]fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
         */
        int n = 6; int s = 4; int a = 5; int b = 6; int[][]fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
        System.out.println(solution(n,s,a,b,fares));
    }
}
