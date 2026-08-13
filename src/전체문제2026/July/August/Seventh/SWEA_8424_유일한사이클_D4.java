package 전체문제2026.July.August.Seventh;

import java.util.*;
import java.io.*;
public class SWEA_8424_유일한사이클_D4 {
    static int N;
    static List<List<Integer>> list;
    static boolean[]visited;
    static int answer;
    static boolean flag;
    static int[]dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
           visited = new boolean[N+1];
           dist = new int[N+1];
           list = new ArrayList<>();
            for(int i=0;i<=N;i++) list.add(new ArrayList<>());
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            flag = false;
            answer = 0;
            dist[0] = 0;
            dfs(0,1);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int before, int cur){
        if(flag) return;
        if(visited[cur]){
            answer = dist[before] - dist[cur] + 1;
            flag = true;
            return;
        }
        dist[cur] = dist[before]+1;
        visited[cur] = true;
        for(int next : list.get(cur)){
            if(next==before) continue;
            dfs(cur,next);
        }
    }
}
