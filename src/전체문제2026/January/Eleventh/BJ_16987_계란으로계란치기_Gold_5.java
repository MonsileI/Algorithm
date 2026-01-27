package 전체문제2026.January.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_16987_계란으로계란치기_Gold_5 {
    static int N;
    static int answer;
    static int[][]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int node,int cnt){
        if(node==N){
            answer = Math.max(answer,cnt);
            return;
        }
        if(arr[node][0]<=0){
            dfs(node+1,cnt);
            return;
        }
        boolean flag = false;
        for(int i=0;i<N;i++){
            if(i==node) continue;
            if(arr[i][0]<1) continue;
            arr[node][0] -= arr[i][1];
            arr[i][0] -= arr[node][1];
            int tmp = cnt;
            if(arr[node][0]<=0) tmp++;
            if(arr[i][0]<=0) tmp++;
            dfs(node+1,tmp);
            arr[node][0] += arr[i][1];
            arr[i][0] += arr[node][1];
        }
        if(!flag) dfs(N,cnt);
    }
}
