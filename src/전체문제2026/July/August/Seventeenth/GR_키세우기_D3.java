package 전체문제2026.July.August.Seventeenth;

import java.util.*;
import java.io.*;
public class GR_키세우기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]depth = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            depth[b]++;
        }
        Queue<Integer> q= new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            if(depth[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node+" ");
            for(int next : list.get(node)){
                depth[next]--;
                if(depth[next]==0){
                    q.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
