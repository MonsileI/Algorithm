package 그래프이론.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_야쿠르트아줌마야쿠르트주세요_Gold_3 {
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
    static int N;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        List<Map<Integer,Integer>> smallList = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
            smallList.add(new HashMap<>());
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(smallList.get(a).containsKey(b)){
                int min = Math.min(w,smallList.get(a).get(b));
                smallList.get(a).put(b,min);
                smallList.get(b).put(a,min);
                continue;
            }
            smallList.get(a).put(b,w);
            smallList.get(b).put(a,w);
        }
        for(int i=0;i<smallList.size();i++){
            for(Integer key : smallList.get(i).keySet()){
                list.get(i).add(new Node(key,smallList.get(i).get(key)));
            }
        }
        int[] oa = new int[10];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<10;i++)oa[i] = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int[] my = dijk(start);
        int before = oa[0];
        long sum = 0;
        int answer = start == oa[0] ? start : Integer.MAX_VALUE;
        for(int i=1;i<10;i++){
              int arrive = dijk(before)[oa[i]];
              if(arrive==Integer.MAX_VALUE) continue;
              sum += arrive;
              before = oa[i];
              if(sum>=my[before] && my[before]!=Integer.MAX_VALUE) answer = Math.min(answer,before);
            }
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);

    }
    static int[] dijk(int start){
        int[]dist = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        return dist;
    }
}
