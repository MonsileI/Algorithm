package 전체문제2026.January.Third;

import java.util.*;
import java.io.*;
public class BJ_5719_거의최단경로_Platinum_5 {
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
    static List<List<Integer>> removeList;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean[][] exRoute;
    static int N;
    static int[]dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            st = new StringTokenizer(br.readLine()," ");
            int S  =Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            removeList = new ArrayList<>();
            list = new ArrayList<>();
            pq = new PriorityQueue<>();
            for(int i=0;i<N;i++) {
                list.add(new ArrayList<>());
                removeList.add(new ArrayList<>());
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(from).add(new Node(to,weight));
            }
            exRoute = new boolean[N][N];
            dijk(S);
            removeVertex(S,E);
            dijk(S);
            sb.append(dist[E] == 987654321? -1 : dist[E]);
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
    static void dijk(int S){
        dist = new int[N];
        Arrays.fill(dist,987654321);
        dist[S] = 0;
        pq.offer(new Node(S,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to] < cur.weight) continue;
            for(Node next : list.get(cur.to)){
                if(exRoute[cur.to][next.to]) continue;
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    removeList.get(next.to).clear();
                    removeList.get(next.to).add(cur.to);
                    pq.offer(new Node(next.to,dist[next.to]));
                }else if(dist[next.to] == dist[cur.to] + next.weight){
                    removeList.get(next.to).add(cur.to);
                }
            }
        }
    }
    static void removeVertex(int s,int e){
        if(s==e) return;
        for(int next : removeList.get(e)) {
            if(!exRoute[next][e]) {
                exRoute[next][e] = true;
                removeVertex(s, next);
            }
        }
    }
}
