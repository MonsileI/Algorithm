package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_14567_선수과목_Gold_5 {
    static int N;
    static int[]depth;
    static List<List<Integer>> child;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        depth = new int[N+1];
        child = new ArrayList<>();
        for(int i=0;i<N+1;i++) child.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            child.get(a).add(b);
            depth[b]++;
        }
        Queue<int[]> q=  new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            if(depth[i]==0){
                q.offer(new int[]{i,1});
            }
        }
        int []answer = new int[N+1];
        while(!q.isEmpty()){
            int []c = q.poll();
            int node = c[0];
            int cnt = c[1];
            answer[node] = cnt;
            for(int next : child.get(node)){
                depth[next]--;
                if(depth[next]==0){
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(answer[i]);
            if(i==N) break;
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
