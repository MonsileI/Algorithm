package 전체문제2026.March.Fifth;

import java.util.*;
import java.io.*;
public class BJ_2673_장난감조립_Gold_2 {

    static class Node{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int N;
    static List<List<Node>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int [] depth = new int[N+1];
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,w));
            depth[to]++;
        }
        Queue<Integer> q= new ArrayDeque<>();
        int[][]dp = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            if(depth[i]==0) {
                q.offer(i);
                dp[i][i] = 1;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();

            for(Node next : list.get(cur)){
                int to = next.to;
                int w = next.weight;

                for(int i=1;i<=N;i++){
                    dp[to][i] += dp[cur][i] * w;
                }
                if(--depth[to]==0){
                    q.offer(to);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(dp[N][i] > 0){
                sb.append(i+" "+dp[N][i]+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
