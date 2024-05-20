package 전체문제.sixth_month_2024_05.thirteenth_2024_05_20;

import java.util.*;
import java.io.*;
public class BJ_28447_마라탕재료고르기_Silver_2 {
    static int N,M;
    static int[][]arr;
    static int answer = -987654321;
    static int[]tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(M==1) System.out.println(0);
        else{
            arr = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            tmp = new int[M];
            comb(0,0);
            System.out.println(answer);

        }
    }
    static void comb(int start,int depth){
        if(depth==M){
            int sum = 0;
            for(int i=0;i<M;i++){
                int node = tmp[i];
                for(int j=i+1;j<M;j++){
                    sum += arr[node][tmp[j]];
                }
            }
            answer = Math.max(answer,sum);
            return;
        }
        for(int i=start;i<N;i++){
            tmp[depth] =i;
            comb(i+1,depth+1);
        }
    }
}
