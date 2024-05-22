package 전체문제.sixth_month_2024_05.fifteenth_2024_05_22;

import java.util.*;
import java.io.*;
public class BJ_9663_NQueen_Gold_4 {
    static int N;
    static int ans;
    static int[]cols;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cols = new int[N];
        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int row){
        if(!check(row-1)) return;
        if(row==N){
            ans++;
            return;
        }
        for(int i=0;i<N;i++){
            cols[row] = i;
            dfs(row+1);
        }
    }
    static boolean check(int row){
        for(int i=0;i<row;i++){
            if(cols[i]==cols[row] || Math.abs(row-i)==Math.abs(cols[row]-cols[i])) return false;
        }
        return true;
    }

}
