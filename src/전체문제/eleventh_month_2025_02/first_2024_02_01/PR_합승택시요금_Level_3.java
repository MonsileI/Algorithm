package 전체문제.eleventh_month_2025_02.first_2024_02_01;

import java.util.*;
import java.io.*;
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
    public static void main(String[] args){

       /*
        int n = 6; int s = 4; int a= 6; int b= 2;
        int{}{}fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int n = 7; int s = 3; int a= 4; int b= 1;
        int{}{}fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
         */
        int n = 6; int s = 4; int a= 5; int b= 6;
        int[][]fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        
        System.out.println(solution(n,s,a,b,fares));
    }
    static int solution(int n,int s,int a,int b,int [][]fares){

        int answer = Integer.MAX_VALUE;
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<fares.length;i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];
            list.get(from).add(new Node(to,weight));
            list.get(to).add(new Node(from,weight));
        }
        for(int i=0;i<n;i++){
            int []dist = djik(n,(i+1),fares);
            if(dist[s]==Integer.MAX_VALUE || dist[a] == Integer.MAX_VALUE || dist[b] == Integer.MAX_VALUE) continue;
            int total = dist[s] + dist[a] + dist[b];
            answer = Math.min(answer,total);
        }
        return answer;
    }

    static int []djik(int n,int start, int[][]fares){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int []dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
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
