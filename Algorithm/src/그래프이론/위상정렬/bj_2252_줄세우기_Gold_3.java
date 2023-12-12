package 그래프이론.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_2252_줄세우기_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dist = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        Queue<Integer> q= new ArrayDeque<>();
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            dist[b]++;
        }
        for(int i=1;i<N+1;i++) if(dist[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int next : list.get(now)){
                dist[next]--;
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
