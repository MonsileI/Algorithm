package 전체문제2026.January.Fourth;

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
    static int N;
    static List<List<Node>> list;
    static boolean[][]isShortest;
    static List<List<Integer>> eraseList;
    static int[]dist;
    static int S,E;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            st =  new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;

            st =new StringTokenizer(br.readLine()," ");
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            eraseList = new ArrayList<>();
            list = new ArrayList<>();
            for(int i=0;i<N;i++) {
                list.add(new ArrayList<>());
                eraseList.add(new ArrayList<>());
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(from).add(new Node(to,weight));
            }
            isShortest = new boolean[N][N];
            dijk();
            deleteShortest(E);
            dijk();
            sb.append(dist[E]==987654321 ? -1 : dist[E]);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
    static void deleteShortest(int cur){
        if(S==cur) return;
        for(Integer next : eraseList.get(cur)){
            if(!isShortest[next][cur]){
                isShortest[next][cur] = true;
                deleteShortest(next);
            }
        }
    }
    static void dijk(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N];
        Arrays.fill(dist,987654321);
        dist[S] = 0;
        pq.offer(new Node(S,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to] > cur.weight) continue;
            for(Node next : list.get(cur.to)){
                if(isShortest[cur.to][next.to]) continue;

                if(dist[next.to] > dist[cur.to] + next.weight){
                    eraseList.get(next.to).clear();
                    eraseList.get(next.to).add(cur.to);
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }else if(dist[next.to] == dist[cur.to] + next.weight){
                    eraseList.get(next.to).add(cur.to);
                }
            }
        }
    }
}
