package 전체문제2026.July.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_4007_간담회참석_D4 {
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
    static int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            List<List<Node>> list = new ArrayList<>();
            List<List<Node>> reverseList = new ArrayList<>();
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
            int[] dist = dijk(X,N,list);
            int[] reverseDist = dijk(X,N,reverseList);
            int max =  0;
            for(int i=1;i<N+1;i++){
                if(dist[i]==INF || reverseDist[i]==INF) continue;
                max = Math.max(max,dist[i]+reverseDist[i]);
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb.toString());
    }
    static int[] dijk(int start,int N,List<List<Node>> list){
        int[]dist = new int[N+1];
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
