package 그래프이론.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13905_세부_Gold_4 {
    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return -(weight - o.weight);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, w));
            list.get(b).add(new Node(a, w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int ans = -1;
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist,987654321);
        pq.offer(new Node(start,987654321));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int from = node.to;
            int weight = node.weight;
            if(visited[from]) continue;
            visited[from] = true;
            if (from == end) {
                ans = Math.max(ans, weight);
                break;
            }
            for (Node next : list.get(from)) {
                next.weight = Math.min(weight, next.weight);
                dist[next.to] = next.weight;
                pq.offer(new Node(next.to, next.weight));
            }
        }
        System.out.println(ans==-1 ? 0 : ans);
    }
}
