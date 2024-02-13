package 그래프이론.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1504_특정한최단경로_Gold_4 {
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
    static boolean firstFlag = true;
    static boolean secondFlag = true;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            list.get(b).add(new Node(a,w));
        }
        st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //시작 -> a -> b -> 끝
        //시작 -> b -> a -> 끝
        int[]dist = dijk(1);
        int[]distA = dijk(a);
        int[]distB = dijk(b);
        int ans = 0;
        if(dist[a]==987654321 || distA[b]==987654321 || distB[N]==987654321) firstFlag = false;
        if(dist[b]==987654321 || distB[a]==987654321 || distA[N]==987654321) secondFlag = false;
        if(!firstFlag && !secondFlag) ans = -1;
        else{
            if(!firstFlag) ans = dist[b]+distB[a]+distA[N];
            else if(!secondFlag) ans = dist[a]+distA[b]+distB[N];
            else{
                ans = Math.min(dist[b]+distB[a]+distA[N],dist[a]+distA[b]+distB[N]);
            }
        }
        System.out.println(ans);
    }
    static int[] dijk(int start){
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;
            for(Node next : list.get(now.to)){
                if(dist[next.to]> dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
