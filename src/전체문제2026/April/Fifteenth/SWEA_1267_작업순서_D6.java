package 전체문제2026.April.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_1267_작업순서_D6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = 10;
        List<List<Integer>> list;
        int[]depth;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            depth = new int[N+1];
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                depth[to]++;
            }
            Queue<Integer> q= new ArrayDeque<>();
            for(int i=1;i<N+1;i++) if(depth[i]==0) q.offer(i);

            sb.append("#"+t+" ");

            while(!q.isEmpty()){
                int c = q.poll();
                sb.append(c+" ");
                for(int next : list.get(c)){
                    depth[next]--;
                    if(depth[next]==0){
                        q.offer(next);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
