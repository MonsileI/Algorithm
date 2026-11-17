package 전체문제2026.November.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_9997_미니멀리즘시계_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int time = Integer.parseInt(br.readLine());
            time *= 2;
            int hour = time / 60;
            int minute = time % 60;
            hour %= 12;
            sb.append("#"+t+" "+hour+" "+minute);
            if(t==TC) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
