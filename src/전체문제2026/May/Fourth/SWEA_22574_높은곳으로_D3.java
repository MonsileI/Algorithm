package 전체문제2026.May.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_22574_높은곳으로_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){

            st =new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int answer = 0;
            for(int i=1;i<=N;i++){
                if(answer+i==P) answer--;
                answer += i;
            }
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
