package 전체문제.eigth_month_2024_07.first_2024_07_01;

import java.util.*;
import java.io.*;
public class BJ_15684_사다리조작_Gold_3 {
    static int H,M;
    static int[][]ladder;
    static int ans;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H][M+1];
        for(int t=0;t<Q;t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            ladder[i][j] = 1;
            ladder[i][j + 1] = 2;
        }
        int ans = 0;

        while(true) {
            dfs(ans);
            if(flag) break;
            ans++;
            if(3<ans) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? ans : -1);
    }
    static void dfs(int depth){
        if(flag) return;
        if(depth==0){
            for(int j=0;j<M;j++){
                int cj = j;
                for(int i=0;i<H;i++){
                    if(ladder[i][cj]==1) cj++;
                    else if(ladder[i][cj]==2) cj--;
                }
                if(j!=cj) return;
            }
            flag = true;
            return;
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<M-1;j++){
                if(ladder[i][j]==0 && ladder[i][j+1]==0){
                    ladder[i][j] = ladder[i][j+1] = 1;
                    ladder[i][j+1]++;
                    dfs(depth-1);
                    ladder[i][j] = ladder[i][j+1] = 0;
                }
            }
        }

    }

}
