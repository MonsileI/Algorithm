package 전체문제2026.January.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_14699_관악산등산_Gold_4 {
    static int N;
    static int[]dist;
    static List<List<Integer>> list;
    static int[]memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        dist = new int[N+1];
        memo = new int[N+1];
        for(int i=1;i<N+1;i++) dist[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
            memo[i] = -1;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1;i<N+1;i++) {
            memo[i] = dfs(i, 1);
        }
        StringBuilder sb=  new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(memo[i]);
            if(i==N) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int dfs(int cur,int cnt){
        if (memo[cur] != -1) return memo[cur];

        int max = 1; // 자기 자신 포함
        for (int next : list.get(cur)) {
            if (dist[cur] < dist[next]) {
                max = Math.max(max, 1 + dfs(next,cnt));
            }
        }
        memo[cur] = max;
        return max;
    }
}
