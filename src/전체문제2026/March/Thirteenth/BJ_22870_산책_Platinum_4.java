package 전체문제2026.March.Thirteenth;

import java.util.*;
import java.io.*;

public class BJ_22870_산책_Platinum_4 {

    static class Node implements Comparable<Node>{
        int to, weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight; // 무조건 weight 기준
        }
    }

    static int N;
    static List<List<Node>> list;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }

        st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(S);
        int[] dist2 = dijkstra(E);

        int totalDist = dist[E];

        // 🔥 S → E 경로 구성 (사전순)
        List<Integer> path = new ArrayList<>();
        int cur = S;
        path.add(cur);

        while(cur != E){
            int nextNode = Integer.MAX_VALUE;

            for(Node next : list.get(cur)){
                // 최단경로 조건
                if(dist[cur] + next.weight + dist2[next.to] == totalDist){
                    if(next.to < nextNode){
                        nextNode = next.to;
                    }
                }
            }

            cur = nextNode;
            path.add(cur);
        }

        // 🔥 경로 중간 노드 set 저장
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<path.size()-1;i++){
            set.add(path.get(i));
        }

        // 🔥 돌아갈 때는 해당 노드 제외
        int answer = totalDist + dijkstraWithBlock(E, S, set);

        System.out.println(answer);
    }

    static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.to] < cur.weight) continue;

            for(Node next : list.get(cur.to)){
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    static int dijkstraWithBlock(int start, int end, Set<Integer> set){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.to] < cur.weight) continue;

            for(Node next : list.get(cur.to)){
                if(set.contains(next.to)) continue;

                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist[end];
    }
}