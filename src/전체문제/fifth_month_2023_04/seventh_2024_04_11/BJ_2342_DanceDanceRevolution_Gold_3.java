package 전체문제.fifth_month_2023_04.seventh_2024_04_11;

import java.util.*;
import java.io.*;
public class BJ_2342_DanceDanceRevolution_Gold_3 {
    static List<Integer> list;
    static int [][][]dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        list = new ArrayList<>();
        while(true){
            int num = Integer.parseInt(st.nextToken());
            if(num==0) break;
            list.add(num);
        }
        dp = new int[list.size()][5][5];
        System.out.println(dfs(0,0,0));
    }
    static int dfs(int left,int right, int idx){
        if(idx==list.size()) return 0;
        if(dp[idx][left][right]!=0) return dp[idx][left][right];

        int newLeft = dfs(list.get(idx),right,idx+1) + move(left,list.get(idx));
        int newRight = dfs(left,list.get(idx),idx+1) + move(right,list.get(idx));
        dp[idx][left][right] = Math.min(newLeft,newRight);
        return dp[idx][left][right];
    }
    static int move(int start,int end){
        if(start==0) return 2;
        if(start==end) return 1;
        if(Math.abs(start-end)==2) return 4;
        return 3;
    }
}
