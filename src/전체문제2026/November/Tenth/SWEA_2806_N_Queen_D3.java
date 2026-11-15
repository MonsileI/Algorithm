package 전체문제2026.November.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_2806_N_Queen_D3 {
    static int N;
    static int[]arr;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            answer = 0;
            Arrays.fill(arr,-1);
            dfs(0, 0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int col,int depth){
        if(depth==N){
            answer++;
            return;
        }
        for(int j=0;j<N;j++){
            if(canMove(col,j)){
                arr[col] = j;
                dfs(col+1,depth+1);
                arr[col] = -1;
            }
        }
    }
    static boolean canMove(int col,int row){
        for(int i=0;i<col;i++){
            if(arr[i]==row || Math.abs(i-col)==Math.abs(arr[i]-row)) return false;
        }
        return true;
    }
}