package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_24479_알고리즘수업_깊이우선탐색1_Silver_2 {

    static List<List<Integer>> list;
    static int num;
    static int[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited = new int[N+1];
        num = 1;
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1;i<N+1;i++) Collections.sort(list.get(i));
        dfs(S);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) sb.append(visited[i]+"\n");
        System.out.println(sb.toString());
    }
    static void dfs(int node){
        visited[node] = num++;
        for(int next : list.get(node)) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }
}
