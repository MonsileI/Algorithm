package 전체문제2026.September.Third;

import java.util.*;
import java.io.*;
public class GR_구름이의여행2_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
        }
        int answer = - 1;
        Queue<int[]> q= new ArrayDeque<>();
        for(int next : list.get(K)){
            q.offer(new int[]{next,1});
        }
        while(!q.isEmpty()){
            int[]c = q.poll();
            int node = c[0]; int cnt = c[1];
            if(node==K){
                answer= cnt;
                break;
            }
            for(int next : list.get(node)){
                q.offer(new int[]{next,cnt+1});
            }
        }
        System.out.println(answer);
    }
}
