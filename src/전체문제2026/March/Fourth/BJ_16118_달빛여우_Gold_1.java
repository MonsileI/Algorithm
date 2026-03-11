package 전체문제2026.March.Fourth;

import java.util.*;
import java.io.*;
public class BJ_16118_달빛여우_Gold_1 {
    static class Node implements Comparable<Node>{
        int to; long weight; boolean isFaster;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
        public Node(int to, long weight, boolean isFaster) {
            this.to = to;
            this.weight = weight;
            this.isFaster = isFaster;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static List<List<Node>> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()) * 10;
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        long[]fox = foxDijk();
        long[][]wolf = wolfDijk();
        int answer = 0;
        for(int i=2;i<N+1;i++){
            if(fox[i] < Math.min(wolf[i][1],wolf[i][0])) answer++;
        }
        System.out.println(answer);
    }
    static long[][] wolfDijk(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[][]dist = new long[N+1][2];
        for(int i=1;i<N+1;i++) Arrays.fill(dist[i],Long.MAX_VALUE);
        dist[1][0] = 0; //초기엔 사용 x
        pq.offer(new Node(1,0,true));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            long weight = cur.weight;
            boolean isFaster = cur.isFaster;
            int state = isFaster ? 0 : 1;
            if(dist[node][state] < weight) continue;
            for(Node next : list.get(node)){
                if(isFaster){
                    if(dist[next.to][1] > weight + (next.weight/2)){
                        dist[next.to][1] = weight + (next.weight/2);
                        pq.offer(new Node(next.to,dist[next.to][1],false));
                    }
                }else{
                    if(dist[next.to][0] > weight + (next.weight*2)){
                        dist[next.to][0] = weight + (next.weight*2);
                        pq.offer(new Node(next.to,dist[next.to][0],true));
                    }
                }

            }
        }
        return dist;
    }
    static long[] foxDijk(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[]dist = new long[N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            long weight = cur.weight;
            if(dist[node] < weight) continue;
            for(Node next : list.get(node)){
                if(dist[next.to] > weight + next.weight){
                    dist[next.to] = weight + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
