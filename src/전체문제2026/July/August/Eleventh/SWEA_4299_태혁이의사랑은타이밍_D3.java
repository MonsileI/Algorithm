package 전체문제2026.July.August.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_4299_태혁이의사랑은타이밍_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int hour = 60;
        int day = hour * 24;
        //11시 11분 부터 24시 00초 까지
        int dDay = (11*day) + (11*hour) + 11;
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = (D*day) +(H*hour) + M;
            answer -= dDay;
            sb.append("#"+t+" ");
            if(answer<0)sb.append(-1);
            else sb.append(answer);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
