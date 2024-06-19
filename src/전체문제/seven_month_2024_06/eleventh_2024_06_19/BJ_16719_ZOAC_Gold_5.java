package 전체문제.seven_month_2024_06.eleventh_2024_06_19;

import java.util.*;
import java.io.*;
public class BJ_16719_ZOAC_Gold_5 {
    static char[]arr;
    static int N;
    static StringBuilder sb;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        N = arr.length;
        visited = new boolean[N];
        sb = new StringBuilder();
        dfs(0,N-1);
        System.out.println(sb.toString());
    }
    static void dfs(int L,int R){
             if(L>R) return;
            int min = arr[L];
            int idx = L;
            for (int i = L; i < R+1; i++) {
                if (visited[i]) continue;
                if (arr[i] < min) {
                    min = arr[i];
                    idx = i;
                }
            }
            visited[idx] = true;
            for (int i = 0; i < N; i++) {
                if (visited[i]) sb.append(arr[i]);
            }
            sb.append("\n");
            dfs(idx + 1, R);
            dfs(L, idx-1);
    }
}
