package 전체문제2026.April.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1210_Ladder1_D4 {
    static int N;
    static int[][]ladder;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = 10;
        N = 100;
        int [][]move = {{1,0},{0,-1},{0,1}};
        while(0<TC) {
            int t = Integer.parseInt(br.readLine());
            ladder = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }
           int answer = 0;
           for(int j=0;j<N;j++){
               if(ladder[0][j]==0) continue;
               int ci = 0;
               int cj = j;
               int d = 0; //지금 위치
               boolean flag = false;
               while(true){
                   ci += move[d][0];
                   cj += move[d][1];
                   //왼쪽 오른쪽 체크
                   if(d==0){
                       int ti = ci +move[1][0];
                       int tj = cj + move[1][1];
                       if(isLine(ti,tj)) {

                           d = 1;
                           continue;
                       }
                       ti = ci + move[2][0];
                       tj = cj + move[2][1];
                       if (isLine(ti, tj)) {

                           d = 2;
                           continue;
                       }
                   }
                   //오른쪽일때, 왼쪽일때
                   else {
                       if(!isLine(ci,cj)){
                           ci -= move[d][0];
                           cj -= move[d][1];
                           d = 0;
                           continue;
                       }
                   }
                   if(ci==N-1) {
                       if(ladder[ci][cj]==2) {
                           flag = true;
                       }
                       break;
                   }
               }
               if(flag){
                   answer = j;
                   break;
               }
           }
           sb.append("#"+t+" "+answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
    static boolean isLine(int i,int j){
        if(i<0||j<0||N-1<i||N-1<j) return false;
        if(ladder[i][j]==0) return false;
        return true;
    }
}
