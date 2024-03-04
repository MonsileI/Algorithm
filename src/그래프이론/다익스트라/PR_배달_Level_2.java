package 그래프이론.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PR_배달_Level_2 {
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
    static int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        int size = road.length;
        for(int i=0;i<size;i++){
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist=  new int[N+1];
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        for(int i=1;i<N+1;i++){
            if(dist[i]<=K) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int N = 5;
        int[][]road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        int result = 4;

        2.
        int N = 6;
        int[][]road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;

        int result = 4;
        * */
        int N = 6;
        int[][]road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;
        System.out.println(solution(N,road,K));

    }
}
