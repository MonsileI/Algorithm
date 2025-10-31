package 전체문제2025.September.Twelveth;

import java.util.*;
import java.io.*;
public class BJ_6987_월드컵_Gold_4 {
    static int[][]check;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < 4; tc++) {
            answer = 0;
            check = new int[6][3];
            st = new StringTokenizer(br.readLine(), " ");
            boolean flag = true;
            for (int i = 0; i < 6; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    check[i][j] = Integer.parseInt(st.nextToken());
                    sum += check[i][j];
                }
                if (sum != 5) {
                    flag = false;
                }
            }
            if (flag) {
                dfs(0, 1);
            }
            sb.append(answer + " ");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int cur, int next){
        if(answer==1) return;
        if(cur==5){
            answer = 1;
            return;
        }

        if(check[cur][0]>0 && check[next][2] > 0){
            check[cur][0]--;
            check[next][2]--;
            if(next==5){
                dfs(cur+1,cur+2);
            }else {
                dfs(cur, next + 1);
            }
            check[cur][0]++;
            check[next][2]++;
        }
        if(check[cur][1]>0 && check[next][1] > 0){
            check[cur][1]--;
            check[next][1]--;
            if(next==5){
                dfs(cur+1,cur+2);
            }else {
                dfs(cur, next + 1);
            }
            check[cur][1]++;
            check[next][1]++;
        }
        if(check[cur][2]>0 && check[next][0]>0){
            check[cur][2]--;
            check[next][0]--;
            if(next==5){
                dfs(cur+1,cur+2);
            }else {
                dfs(cur, next + 1);
            }
            check[cur][2]++;
            check[next][0]++;
        }
    }
}
