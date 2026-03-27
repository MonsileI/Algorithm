package 전체문제2026.March.Sixteenth;

import java.util.*;
import java.io.*;
public class BJ_2252_줄세우기_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]depth = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            depth[s]++;
            list.get(f).add(s);
        }
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(depth[i]==0) q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+" ");
            for(int next : list.get(cur)){
                depth[next]--;
                if(depth[next]==0){
                    q.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}