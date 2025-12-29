package 전체문제2025.December.Tenth;

import java.util.*;
import java.io.*;
public class BJ_16928_뱀과사다리게임_Gold_5  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int L = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[]dist = new int[101];
        // 주사위 1,2,3,4,5,6
        int[]link = new int[101];
        for(int i=0;i<L+S;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            link[from] = to;
        }
        Queue<int[]> q= new ArrayDeque<>();
        Arrays.fill(dist,987654321);
        dist[1] = 0;
        q.offer(new int[]{1,0}); //첫 칸
        int answer = 987654321;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int cnt = c[1];
            if(i==100){
                answer = Math.min(answer,cnt);
                continue;
            }
            if(link[i]!=0) {
                q.offer(new int[]{link[i],cnt});
                continue;
            }
            for(int d=1;d<7;d++){
                int ni = i + d;
                if(100<ni) continue;
                if(dist[ni]<(cnt+1)) continue;
                dist[ni] = cnt+1;
                q.offer(new int[]{ni,cnt+1});
            }
        }
        System.out.println(answer);
    }
}
