package 전체문제.eigth_month_2024_07.sixth_2024_07_10;

import java.util.*;
import java.io.*;
public class GR_양팔저울_Level_2 {
    static int N;
    static int[] arr;
    static int sum;
    static boolean[]check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        check = new boolean[sum+1];
        dfs(0,0);
        int ans = 0;
        for(int i=1;i<sum+1;i++) if(!check[i]) ans++;
        System.out.println(ans);
    }
    static void dfs(int depth, int sum){
        if(depth==N){
            if(sum>0) check[sum] = true;
            return;
        }
        dfs(depth+1,sum+arr[depth]);
        dfs(depth+1,sum);
        dfs(depth+1,sum-arr[depth]);
    }
}
