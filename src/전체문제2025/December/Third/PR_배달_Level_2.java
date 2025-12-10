package 전체문제2025.December.Third;

import java.util.*;

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
    public static void main(String[] args) {
        int N = 5;
        int[][]road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        System.out.println(solution(N,road,K));
    }
    static int solution(int N, int[][] road, int K){
        int max = 987564321;
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b  = road[i][1];
            int w  = road[i][2];
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        Arrays.fill(dist,max);
        dist[1] = 0;
        pq.offer(new Node(1,0));
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
        int answer = 0;
        for(int i=1;i<N+1;i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}
