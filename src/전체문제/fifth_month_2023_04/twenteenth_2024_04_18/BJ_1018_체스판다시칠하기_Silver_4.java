package 전체문제.fifth_month_2023_04.twenteenth_2024_04_18;

import java.util.*;
import java.io.*;
public class BJ_1018_체스판다시칠하기_Silver_4 {
    static int N,M;
    static int ans;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        ans = 987654321;
        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                dfs(i,j);
            }
        }
        System.out.println(ans);
    }
    static void dfs(int y,int x){
        int f = 0; int s = 0;
        boolean fir = false; //처음이 B
        boolean sec = false; //처음이 W
        for(int i=y;i<y+8;i++){
            fir = !fir; sec = !sec;
            for(int j=x;j<x+8;j++){
                  char ch = map[i][j];
                  if(ch=='B'){
                      if(fir) f++;
                      if(!sec)s++;
                  }else{
                      if(sec) s++;
                      if(!fir)f++;
                  }
                  fir = !fir;
                  sec = !sec;
            }
            if(ans<f&&ans<s) return;
        }
        ans = Math.min(f,s);
    }
}
