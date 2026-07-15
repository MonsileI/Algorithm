package 전체문제2026.July.Seventh;

import java.util.*;
import java.io.*;
public class SWEA3952_줄세우기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[]depth = new int[N+1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                depth[b]++;
            }
            Queue<Integer> q=  new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                if(depth[i]==0) q.offer(i);
            }
            sb.append("#"+t+" ");
            while(!q.isEmpty()){
                int node = q.poll();
                sb.append(node+" ");
                for(Integer next : list.get(node)){
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
