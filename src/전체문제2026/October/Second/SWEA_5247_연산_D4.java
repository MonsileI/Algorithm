package 전체문제2026.October.Second;

import java.util.*;
import java.io.*;
public class SWEA_5247_연산_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = null;
        StringBuilder sb = new StringBuilder();
        //+1 -1 *2 -10
        int TC = Integer.parseInt(br.readLine());
        int maxValue = 1000001;
        for(int t=1;t<=TC;t++) {
            boolean[] visited = new boolean[maxValue];
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited[N] = true;
            int answer = 0;
            Queue<int[]> q= new ArrayDeque<>();
            q.offer(new int[]{N,0});
            while(!q.isEmpty()){
                int[]c = q.poll();
                int num = c[0]; int cnt= c[1];
                if(num==M){
                    answer = cnt;
                    break;
                }
                if(num*2<maxValue){
                    if(!visited[num*2]){
                        visited[num*2] = true;
                        q.offer(new int[]{num*2,cnt+1});
                    }
                    if(!visited[num+1]){
                        visited[num+1] = true;
                        q.offer(new int[]{num+1,cnt+1});
                    }
                }
                if(0<=num-10){
                    if(!visited[num-10]){
                        visited[num-10] = true;
                        q.offer(new int[]{num-10,cnt+1});
                    }
                    if(!visited[num-1]){
                        visited[num-1] = true;
                        q.offer(new int[]{num-1,cnt+1});
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
