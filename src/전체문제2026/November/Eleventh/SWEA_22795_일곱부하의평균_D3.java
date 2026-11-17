package 전체문제2026.November.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_22795_일곱부하의평균_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            st =new StringTokenizer(br.readLine()," ");
            int sum = 0;
            int max = 0;
            for(int i=0;i<6;i++){
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                max = Math.max(max,num);
            }
            int namuzi = (sum+max)%7;
            int answer = max + (7-namuzi);
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
