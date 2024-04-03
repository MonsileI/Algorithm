package 전체문제.fifth_month_2023_04.second_2024_04_02;

import java.util.*;
import java.io.*;
public class  BJ_15684_사다리조작_Gold_3 {
    static int [][] info;
    static int ans;
    static boolean flag;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        info = new int[N+1][M+1];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[a][b] = 1;
            info[a][b+1] = 2;
        }
        for(int i=0;i<4;i++){
            dfs(0,i);
            if(flag) break;
        }
        System.out.println(flag ? ans : -1);
    }
    static boolean check(){

        for(int j=1;j<M+1;j++){
            int node = j;
            for(int i=1;i<N+1;i++){
                if(info[i][node]==1) node++;
                else if(info[i][node]==2) node--;
            }
            if(node!=j) return false;
        }

        return true;
    }
    static void dfs(int depth,int count){
        if(flag) return;
        if(depth==count){
            if(check()){
                flag = true;
                ans = depth;
            }
            return;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M;j++){
                if(info[i][j]==0 && info[i][j+1]==0){
                    info[i][j] = 1; info[i][j+1] =2;
                    dfs(depth+1,count);
                    info[i][j] = info[i][j+1] = 0;
                }
            }
        }


    }
}
