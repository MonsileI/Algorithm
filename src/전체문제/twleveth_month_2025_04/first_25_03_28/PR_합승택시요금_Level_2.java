package 전체문제.twleveth_month_2025_04.first_25_03_28;

import java.util.*;

public class PR_합승택시요금_Level_2 {


    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static List<List<Node>> list;
    static int N;

    static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {

    int[][]fares = {{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};
    N = 6;
    System.out.println(solution(6,4,5,6,fares));
    }

    static int solution(int n, int s , int a, int b, int [][] fares){
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        int M = fares.length;
        for(int i=0;i<M;i++){
            int start = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];
            list.get(start).add(new Node(to,weight));
            list.get(to).add(new Node(start,weight));
        }

        int[]sArray = dijk(s);
        int[]aArray = dijk(a);
        int[]bArray = dijk(b);
        int answer = MAX_VALUE;
        for(int i=1;i<N+1;i++){
            if(aArray[i] == MAX_VALUE || bArray[i] == MAX_VALUE || sArray[i] == MAX_VALUE) continue;
            answer = Math.min(answer, (aArray[i] + bArray[i] + sArray[i]));
        }

        return answer;
    }

    static int[] dijk(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        Arrays.fill(dist,MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start,0));
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

        return dist;
    }
}
