package 전체문제2026.March.Third;

import java.util.*;
import java.io.*;
public class BJ_1219_오만식의고민_Platinum_5 {
    static class Node {
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }


    }
    static int N;
    static List<List<Node>> list;
    static int[]cityMoney;
    static long[]dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        cityMoney = new int[N];
        for(int i=0;i<N;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) cityMoney[i] = Integer.parseInt(st.nextToken());
        dist = new long[N];
        int MIN = Integer.MIN_VALUE;
        Arrays.fill(dist,MIN);
        dist[start] = cityMoney[start];
        boolean ggFlag = false;
        boolean[]cycle = new boolean[N];
        for(int i = 0; i < N; i++){
            for(int from = 0; from < N; from++){

                for(Node next : list.get(from)){

                    if(dist[from] == MIN) continue;

                    if(dist[next.to] < dist[from] - next.weight + cityMoney[next.to]){
                        dist[next.to] = dist[from] - next.weight + cityMoney[next.to];

                        if(i == N-1){
                            cycle[next.to] = true;
                        }
                    }
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[]visited = new boolean[N];
        for(int i=0;i<N;i++){
            if(cycle[i]){
                q.offer(i);
                visited[i] = true;
            }
        }
        boolean GeeFlag = false;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur==end){
                GeeFlag = true;
                break;
            }
            for(Node next : list.get(cur)){
                if(!visited[next.to]){
                    visited[next.to] = true;
                    q.offer(next.to);
                }
            }
        }
        if(GeeFlag) System.out.println("Gee");
        else if(dist[end] == MIN) System.out.println("gg");
        else System.out.println(dist[end]);

    }

}
