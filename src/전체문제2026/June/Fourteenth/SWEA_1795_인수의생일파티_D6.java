package 전체문제2026.June.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_1795_인수의생일파티_D6 {

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
    static int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            list = new ArrayList<>(); reverseList = new ArrayList<>();
            for(int i=0;i<N+1;i++){
                list.add(new ArrayList<>());
                reverseList.add(new ArrayList<>());
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,w));
                reverseList.get(b).add(new Node(a,w));
            }
            int[]dist = dijk(start,list);
            int[]reverseDist = dijk(start,reverseList);
            int answer = 0;
            for(int i=1;i<N+1;i++){
                if(i==start) continue;
                int sum = dist[i] + reverseDist[i];
                answer = Math.max(answer,sum);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static int[] dijk(int start,List<List<Node>> list){
        int[]dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = cur.to; int weight = cur.weight;
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
