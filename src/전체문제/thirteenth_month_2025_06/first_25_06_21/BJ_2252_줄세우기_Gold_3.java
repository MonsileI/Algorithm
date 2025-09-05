package 전체문제.thirteenth_month_2025_06.first_25_06_21;

import java.util.*;
import java.io.*;
public class BJ_2252_줄세우기_Gold_3 {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[]dist = new int[N+1];
        for(int i=0;i<N+1;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            dist[b]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(dist[i]==0) {
                q. offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int node = q.poll();
            if(dist[node] == 0){
                sb.append(node+" ");
            }
            for(int next : list.get(node)){
                dist[next]--;
                if(dist[next]==0) q.offer(next);
            }
        }

        System.out.println(sb.toString());
    }
}
