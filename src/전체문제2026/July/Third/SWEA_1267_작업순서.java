package 전체문제2026.July.Third;

import java.util.*;
import java.io.*;
public class SWEA_1267_작업순서  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb =new StringBuilder();
        int TC = 10;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<V+1;i++) list.add(new ArrayList<>());
            int[]depth = new int[V+1];
            for(int i=0;i<E;i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                depth[b]++;
            }
            Queue<Integer> q= new ArrayDeque<>();
            for(int i=1;i<V+1;i++) {
                if(depth[i]==0) q.offer(i);
            }
            sb.append("#"+t+" ");
            while(!q.isEmpty()){
                int c = q.poll();
                sb.append(c+" ");
                for(Integer next : list.get(c)){
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
