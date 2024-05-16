package 전체문제.sixth_month_2024_05.eleventh_2024_05_16;

import java.util.*;
import java.io.*;
public class BJ_1766_문제집_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dist=  new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[b]++;
            list.get(a).add(b);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<N+1;i++) if(dist[i]==0) pq.offer(i);
        StringBuilder sb= new StringBuilder();
        while(!pq.isEmpty()){
            int node = pq.poll();
            sb.append(node+" ");
            for(int next : list.get(node)){
                dist[next]--;
                if(dist[next]==0) pq.offer(next);
            }
        }
        System.out.println(sb.toString());
    }
}
