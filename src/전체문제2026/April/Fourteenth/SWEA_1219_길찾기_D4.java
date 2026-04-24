package 전체문제2026.April.Fourteenth;

import java.util.*;
import java.io.*;
public class SWEA_1219_길찾기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();

        int TC = 10;
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int t= Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            boolean[][]pw = new boolean[100][100];
            for(int i=0;i<N;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                pw[from][to] = true;
            }
            for(int l=0;l<100;l++){
                for(int i=0;i<100;i++){
                    for(int j=0;j<100;j++){
                        if(i==j) pw[i][j] = true;
                        if(pw[i][j]) continue;
                        if(pw[i][l] && pw[l][j]) pw[i][j] = true;

                    }
                }
            }
            sb.append("#"+t+" ");
            sb.append(pw[0][99] ? 1 : 0);
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
