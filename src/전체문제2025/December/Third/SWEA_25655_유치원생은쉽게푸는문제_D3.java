package 전체문제2025.December.Third;

import java.util.*;
import java.io.*;
public class SWEA_25655_유치원생은쉽게푸는문제_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        while(0<TC){
            TC--;
            int N = Integer.parseInt(br.readLine());
            /*
            0 6 8 9
            1 1 2 1

            0 6 8 9  68 -3개 69 - 2개 86 - 3개
            1 1 2 1

            1개 -> 0 6 9
            2개 -> 8
            3개 -> 80
            4개 -> 88
            5개 -> 688
            */
            if(N==1) {
                sb.append(0);
                sb.append("\n");
                continue;
            }

            String str = "";
            if(N%2==1) {
                str += "4";
                N--;
            }
            for(int i=0;i<N;i+=2){
                str += "8";
            }
            sb.append(str);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
