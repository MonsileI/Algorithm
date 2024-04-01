package 전체문제.fifth_month_2023_04.first_2024_04_01;


import java.util.*;
import java.io.*;
public class BJ_1516_게임개발_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[]arr = new int[N+1];
        int[]max = new int[N+1];
        int[]dist = new int[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        int[]ans = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next==-1) break;
                list.get(next).add(i);
                dist[i]++;
            }
            if(dist[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int now = q.poll();
            ans[now] = arr[now]+max[now];
            for(int next : list.get(now)){
                dist[next]--;
                max[next] = Math.max(max[next],ans[now]);
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++)sb.append(ans[i]+"\n");
        System.out.println(sb.toString());

    }
}
