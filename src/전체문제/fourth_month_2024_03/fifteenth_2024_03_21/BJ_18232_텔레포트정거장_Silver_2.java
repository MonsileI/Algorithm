package 전체문제.fourth_month_2024_03.fifteenth_2024_03_21;
import java.util.*;
import java.io.*;
public class BJ_18232_텔레포트정거장_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[]visited = new boolean[N+1];
        int ans = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
           list.get(from).add(to);
           list.get(to).add(from);
        }

        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{a,0});
        visited[a] = true;
        while(!q.isEmpty()){
            int [] c= q.poll();
            int now = c[0]; int cnt = c[1];
            if(now==b){
                ans = cnt;
                break;
            }
            if(now+1<N+1 && !visited[now+1]){
                visited[now+1] = true;
                q.offer(new int[]{now+1,cnt+1});
            }
            if(0<now-1 && !visited[now-1]){
                visited[now-1] = true;
                q.offer(new int[]{now-1,cnt+1});
            }
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        System.out.println(ans);
    }
}
