package 전체문제2026.September.Thirteenth;

import java.util.*;
import java.io.*;
public class GR_퍼져나가는소문_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int answer = 1;
        Queue<Integer> q= new ArrayDeque<>();
        boolean[]visited=  new boolean[N+1];
        visited[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    answer++;
                    q.offer(next);
                }
            }
        }
        System.out.println(answer);
    }
}
