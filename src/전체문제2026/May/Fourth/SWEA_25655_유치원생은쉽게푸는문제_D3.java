package 전체문제2026.May.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_25655_유치원생은쉽게푸는문제_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            TC--;
            int N = Integer.parseInt(br.readLine());
            if(N==1) {
                sb.append(0+"\n");
                continue;
            }
            if(N%2==1){
                sb.append(4);
                N--;
            }
            for(int i=0;i<N/2;i++){
                sb.append(8);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
