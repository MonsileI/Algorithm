package 전체문제2026.May.Twelfth;

import java.util.*;

public class PR_등산코스_Level_3 {
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
        int n = 7;
        int[][]paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
        int[]gate = {1};
        int[]summits = {2, 3, 4};
        System.out.println(Arrays.toString(solution(n,paths,gate,summits)));
    }
    static int N;
    static List<List<Node>> list;
    static int minAnswer;
    static int summit;
    static boolean[]Gates;
    static boolean[]Summits;
    static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        list = new ArrayList<>();
        for(int i=0;i<n+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<paths.length;i++){
            int a = paths[i][0];
            int b = paths[i][1];
            int w = paths[i][2];
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        Gates = new boolean[n+1];
        Summits = new boolean[n+1];

        for(int i=0;i< gates.length;i++){
            Gates[gates[i]] = true;
        }
        for(int i=0;i<summits.length;i++){
            Summits[summits[i]] = true;
        }
        minAnswer = Integer.MAX_VALUE;
        for(int i=0;i<gates.length;i++){
            dijk(gates[i]);
        }
        int[]answer = {summit,minAnswer};
        return answer;
    }
    static void dijk(int gate){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        int bon = -1;
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[gate] = 0;
        pq.offer(new Node(gate,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight = cur.weight;
            if(Summits[node]){
                if(min > weight){
                    min = weight;
                    bon = node;
                }else if(min == weight){
                    if(node<bon){
                        bon = node;
                    }
                }
                continue;
            }
            if(minAnswer < weight) continue;
            if(dist[node] < weight) continue;
            for(Node next : list.get(node)){
                if(Gates[next.to]) continue;
                int max = Math.max(weight,next.weight);
                if(dist[next.to] > max) {
                    dist[next.to] = max;
                    pq.offer(new Node(next.to, Math.max(weight, max)));
                }
            }
        }
        if(min<minAnswer){
            minAnswer = min;
            summit = bon;
        }else if(min==minAnswer){
            if(bon<summit){
                summit = bon;
            }
        }

    }
}
