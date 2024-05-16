package 그래프이론.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
