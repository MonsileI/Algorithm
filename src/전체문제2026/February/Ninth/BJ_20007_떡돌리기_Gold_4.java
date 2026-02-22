package 전체문제2026.February.Ninth;

import java.util.*;
import java.io.*;
public class BJ_20007_떡돌리기_Gold_4 {
    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight -o.weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()); //최소 방문
        int Y = Integer.parseInt(st.nextToken()); //우리 집
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N];
        int MAX = 987654321;
        Arrays.fill(dist,MAX);
        dist[Y] = 0;
        pq.offer(new Node(Y,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int node = cur.to;
            int weight = cur.weight;
            if(dist[node] < weight) continue;
            for(Node next : list.get(node)){
                if(dist[next.to] > dist[node] + next.weight){
                    dist[next.to] = dist[node] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        int answer= 0;
        int cur = 0;
        boolean flag = true;
        Arrays.sort(dist);
        for(int i=0;i<N;i++){
            if(X < dist[i]*2){
                flag = false;
                break;
            }
            if(X < cur + dist[i]*2){
                answer++;
                cur = dist[i]*2;
            }else{
                cur += dist[i]*2;
            }
        }
        if(cur!=0) answer++;
        System.out.println(flag == false ? -1 : answer);
    }
}
