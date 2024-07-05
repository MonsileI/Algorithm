package 전체문제.eigth_month_2024_07.third_2024_07_05;

import java.util.*;
import java.io.*;
public class BJ_14224_편의점_Gold_3 {
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
    static Map<Integer,Integer> map;
    static int[]pyun;
    static int pSize;
    static int ans;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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
        st = new StringTokenizer(br.readLine()," ");
        int hSize = Integer.parseInt(st.nextToken());
        pSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        map = new HashMap<>();
        for(int i=0;i<hSize;i++) {
            map.put(Integer.parseInt(st.nextToken()),0);
        }
        st = new StringTokenizer(br.readLine()," ");
        ans = 0;
        pyun = new int[pSize];
        for(int i=0;i<pSize;i++) pyun[i] = Integer.parseInt(st.nextToken());
        dijk();
        System.out.println(ans);
    }
    static void dijk(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[]dist = new int[N+1];
        Arrays.fill(dist,987654321);
        for(int i=0;i<pSize;i++){
            pq.offer(new Node(pyun[i],0));
            dist[pyun[i]] = 0;
        }
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;
            if(min<now.weight) continue;
            if(map.containsKey(now.to)){
                if(min==now.weight) ans = Math.min(ans,now.to);
                else ans = now.to;
                min = now.weight;
                continue;
            }
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }

    }
}
