package 전체문제.seventh_month_2024_06.first_2024_06_03;
import java.util.*;
import java.io.*;
public class BJ_16719_ZOAC_Gold_5 {
    static StringBuilder sb;
    static char[] arr;
    static boolean []visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        N = arr.length;
        visited=  new boolean[N];
        dfs(0,N-1);
        System.out.println(sb.toString());
    }
    static void dfs(int left,int right){

        int idx = left;
        for(int i=left;i<right+1;i++){
            if(arr[idx]>arr[i]){
                idx = i;
            }
        }
        visited[idx]= true;
        for(int i=0;i<N;i++){
            if(visited[i]) sb.append(arr[i]);
        }
        dfs(idx+1,right);
        dfs(left,idx-1);
    }
}
