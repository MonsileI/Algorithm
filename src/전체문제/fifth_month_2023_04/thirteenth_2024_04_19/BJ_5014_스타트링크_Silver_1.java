package 전체문제.fifth_month_2023_04.thirteenth_2024_04_19;
import java.util.*;
import java.io.*;
public class BJ_5014_스타트링크_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[]dist = new int[F+1];
        dist[S] = 0;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{S,0});
        boolean flag = false;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int now = c[0]; int cnt = c[1];
            if(now==G) {
                flag = true;
                break;
            }
            if(now+U<=F){
                if(dist[now+U]==0) {
                    dist[now+U] = cnt+1;
                    q.offer(new int[]{(now + U), cnt + 1});
                }
            }
            if(0<now-D){
                if(dist[now-D]==0){
                    dist[now-D] = cnt+1;
                    q.offer(new int[]{(now-D),cnt+1});
                }
            }
        }
        System.out.println(flag ? dist[G] : "use the stairs");
    }
}
