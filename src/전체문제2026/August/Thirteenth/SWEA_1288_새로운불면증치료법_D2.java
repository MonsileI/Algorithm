package 전체문제2026.August.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1288_새로운불면증치료법_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int allBit = 1;
        for(int i=1;i<=9;i++) allBit = allBit | 1 << i;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int bit = 0;
            int gop = 1;
            int answer = 0;
            int change = N;
            while(true){
                String tmp = String.valueOf(change);
                for(int i=0;i<tmp.length();i++){
                    int num = tmp.charAt(i) - '0';
                    bit = bit | 1 << num;
                }
                if((bit & allBit) == allBit) break;
                change = (N*gop);
                gop++;
                answer++;
            }
            sb.append("#"+t+" "+(N*answer)+"\n");
        }
        System.out.println(sb.toString());
    }
}
