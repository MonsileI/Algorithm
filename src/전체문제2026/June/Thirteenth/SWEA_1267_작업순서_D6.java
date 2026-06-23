package 전체문제2026.June.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1267_작업순서_D6  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=10;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            st =new StringTokenizer(br.readLine()," ");
            int[]dist = new int[N+1];
            for(int i=0;i<M;i++){
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list.get(f).add(s);
                dist[s]++;
            }
            Queue<Integer> q= new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                if(dist[i]==0) q.offer(i);
            }
            sb.append("#"+t+" ");
            while(!q.isEmpty()){
                int c = q.poll();
                sb.append(c+" ");
                for(int next : list.get(c)){
                    dist[next]--;
                    if(dist[next]==0) q.offer(next);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
