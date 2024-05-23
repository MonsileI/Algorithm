package 전체문제.sixth_month_2024_05.sixteenth_2024_05_23;

import java.util.*;
import java.io.*;
public class BJ_15684_사다리조작_Gold_3 {
    static int N,H;
    static int [][]ladder;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1; ladder[a][b+1] = 2;
        }

        int cnt  = 0;
        while(true){
            if(cnt>3) {
                cnt = -1;
                break;
            }
            dfs(cnt);
            if(flag) break;
            cnt++;
        }
        System.out.println(cnt);
    }
    static void dfs(int depth){
        if(flag) return;
        if(depth==0){
            if(calc()) flag = true;
            return;
        }

        for(int i=1;i<H+1;i++){
            for(int j=1;j<N;j++){
                if(ladder[i][j]==0 && ladder[i][j+1]==0){
                    ladder[i][j] = 1; ladder[i][j+1]= 2;
                    dfs(depth-1);
                    ladder[i][j] = ladder[i][j+1]= 0;
                }
            }
        }
    }
    static boolean calc(){

        //1번부터 N번까지 돌려보기
        for(int j=1;j<N+1;j++){
            int i = 1;
            int cj = j; //처음 값
            while(true){
                if(ladder[i][cj]==2) cj--;
                else if(ladder[i][cj]==1) cj++;
                i++;
                if(i==H+1) break;
            }
            if(cj!=j) return false;
        }
        return true;
    }
}
