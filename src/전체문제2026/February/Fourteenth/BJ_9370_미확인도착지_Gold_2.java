package 전체문제2026.February.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_9370_미확인도착지_Gold_2 {
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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken()); //목적지 후보군

            st = new StringTokenizer(br.readLine()," ");
            int S = Integer.parseInt(st.nextToken()); //출발지
            int G = Integer.parseInt(st.nextToken()); // 사이에 있는 곳을 지나갔음
            int H = Integer.parseInt(st.nextToken()); // 사시에 있는 곳을 지나갔음
            list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b,w));
                list.get(b).add(new Node(a,w));
            }
            int[]sDist = dijk(S);
            int[]hDist = dijk(H);
            int[]gDist = dijk(G);
            int[]target = new int[T];
            for(int i=0;i<T;i++) target[i] = Integer.parseInt(br.readLine());
            Arrays.sort(target);
            for(int i=0;i<T;i++){
                int node = target[i];
                if(sDist[node]==(sDist[G]+gDist[H]+hDist[node]) ||
                    sDist[node]==(sDist[H]+hDist[G]+gDist[node])
                ){
                    sb.append(node+" ");
                }
            }
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
    static int[] dijk(int start){
        int[]dist = new int[N+1];
        PriorityQueue<Node> pq =new PriorityQueue<>();
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist,INF);
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight =cur.weight;
            if(dist[node] < weight) continue;
            for(Node next : list.get(node)){
                if(dist[next.to] > dist[node] + next.weight){
                    dist[next.to] = dist[node] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
