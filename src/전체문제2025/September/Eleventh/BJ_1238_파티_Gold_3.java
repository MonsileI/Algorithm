package 전체문제2025.September.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1238_파티_Gold_3  {
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
    static List<List<Node>> list;
    static List<List<Node>> reverseList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(); reverseList = new ArrayList<>();
        for(int i=0;i<N+1;i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
            reverseList.get(to).add(new Node(from,weight));
        }
        int answer = 0;
        int [] dist = dijk(X,list);
        int [] reverseDist = dijk(X,reverseList);
        for(int i=1;i<N+1;i++) {
            if(i==X) continue;
            answer = Math.max(answer, dist[i]+reverseDist[i]);
        }
        System.out.println(answer);

    }
    static int[] dijk(int start, List<List<Node>> list){

        int[]dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
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
