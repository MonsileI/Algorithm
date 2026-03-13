package 전체문제2026.March.Eighth;

import java.util.*;
import java.io.*;
public class BJ_34949_이대로가면돼요_Gold_5 {
    static int N;
    static int[]arr;
    static int[]memo;
    static int[]state;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N+1];
        memo = new int[N+1];
        state= new int[N+1];
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        Arrays.fill(memo,-1);
        for(int i=1;i<N+1;i++){
            sb.append(dfs(i)+"\n");
        }
        System.out.println(sb.toString());
    }
    static int dfs(int node){
        if(node==N) return 0;
        if(state[node]==1) return -1; // cycle
        if(state[node]==2) return memo[node];

        state[node]=1;

        int res = dfs(arr[node]);
        if(res==-1) memo[node] = -1;
        else memo[node] = res+1;

        state[node]=2;
        return memo[node];
    }

}
