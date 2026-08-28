package 전체문제2026.July.August.Twentieth;

import java.util.*;
import java.io.*;
public class GR_사은품교환하기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            long answer = 0;
            st = new StringTokenizer(br.readLine()," ");
            long N = Long.parseLong(st.nextToken()); //N이 최고 5개
            long M = Long.parseLong(st.nextToken());
            long nCnt = N/5;
            long mCnt = M/7;
            long min = Math.min(nCnt,mCnt);
            answer = min;
            N -= (min*5);
            M -= (min*7);
            if(4<N){
                N += M;
                answer += (N/12);
            }

            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}