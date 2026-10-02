package 전체문제2026.October.First;

import java.util.*;
import java.io.*;
public class GR_구름이의여행_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        boolean[]visited = new boolean[N+1];
        visited[1] = true;
        boolean flag = false;
        while(!q.isEmpty()){
            int []cur = q.poll();
            int node = cur[0]; int cnt = cur[1];
            if(node==N){
                if(cnt<=K) flag = true;
                break;
            }
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");

    }
}
