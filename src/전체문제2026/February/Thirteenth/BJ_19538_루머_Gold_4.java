package 전체문제2026.February.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_19538_루머_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<List<Integer>> list = new ArrayList<>();
        int[]depth = new int[N+1];
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=1;i<N+1;i++){
            st=  new StringTokenizer(br.readLine()," ");
            while(true){
                int node = Integer.parseInt(st.nextToken());
                if(node==0) break;
                list.get(i).add(node);
                depth[i]++;
            }
        }

        int t = Integer.parseInt(br.readLine());
        Queue<int[]> q= new ArrayDeque<>();
        st = new StringTokenizer(br.readLine()," ");
        int[]dist = new int[N+1];
        Arrays.fill(dist,-1);
        boolean[]visited = new boolean[N+1];
        for(int i=0;i<t;i++){
            int num = Integer.parseInt(st.nextToken());
            q.offer(new int[]{num,0});
            visited[num] = true;
        }
        while(!q.isEmpty()){
            int[]c = q.poll();
            int node = c[0];
            int cnt = c[1];
            dist[node] = cnt;
            for(int next : list.get(node)){
                depth[next]--;
                if(!visited[next] && depth[next]<= (list.get(next).size()/2)){
                    visited[next] = true;
                    q.offer(new int[]{next,cnt+1});
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(dist[i]+" ");
        }

        System.out.println(sb.toString());
    }
}
