package 전체문제2026.June.Fifteenth;

import java.util.*;
import java.io.*;
public class  SWEA_1265_달란트2_D5{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //기준
            int avg = N/M;
            int namusi = N%M;
            long answer = 1;
            for(int i=0;i<M;i++){
                if(namusi<1) {
                    answer *= avg;
                }else{
                    answer *= (avg+1);
                    namusi--;
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}