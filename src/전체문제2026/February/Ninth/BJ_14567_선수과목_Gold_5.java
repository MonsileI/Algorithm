package 전체문제2026.February.Ninth;

import java.util.*;
import java.io.*;
public class BJ_14567_선수과목_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dist = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            dist[b]++;
        }
        Queue<int[]> q= new ArrayDeque<>();
        int[]answer = new int[N+1];
        for(int i=1;i<N+1;i++) {
            if(dist[i]==0) q.offer(new int[]{i,1});
        }
        while(!q.isEmpty()){
            int []c = q.poll();
            int node = c[0];
            int depth = c[1];
            answer[node] = depth;
            for(int next : list.get(node)){
                dist[next]--;
                if(dist[next]==0) q.offer(new int[]{next,depth+1});
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(answer[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
