package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_27971_강아지는많을수록좋다_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        //BFS?
        boolean[]check = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for(int j=from;j<=to;j++){
                check[j] = true;
            }
        }
        Queue<int[]> q =new ArrayDeque<>();
        boolean[]visited = new boolean[N+1];
        q.offer(new int[]{0,0}); // range, cnt

        int ans = -1;
        while(!q.isEmpty()){
            int []c = q.poll();
            int now = c[0]; int cnt = c[1];
            if(now==N){
                ans = cnt;
                break;
            }
            int next = now + A;
            if(next<=N){
                if(!visited[next]&&!check[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
            next = now + B;
            if(next<=N){
                if(!visited[next]&&!check[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        System.out.println(ans);

    }
}
