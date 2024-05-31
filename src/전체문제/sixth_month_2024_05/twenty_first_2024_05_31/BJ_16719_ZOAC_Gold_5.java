package 전체문제.sixth_month_2024_05.twenty_first_2024_05_31;

import java.util.*;
import java.io.*;
public class BJ_16719_ZOAC_Gold_5 {


    static StringBuilder sb=  new StringBuilder();
    static char[]arr = null;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        N = arr.length;
        visited = new boolean[N];
        //빠른걸로 넘버링?
        dfs(0,N-1);
        System.out.println(sb.toString());
    }
    static void dfs(int left,int right){
        if(left>right) return;
        int idx = left;
        for(int i=left;i<right+1;i++){
            if(arr[i]<arr[idx]){
                idx = i;
            }
        }
        visited[idx] = true;
        for(int i=0;i<N;i++){
            if(visited[i]) sb.append(arr[i]);
        }
        sb.append("\n");
        dfs(idx+1,right);
        dfs(left,idx-1);
    }
}
