package 전체문제2026.November.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_16003_화면캡쳐_D4 {
    static int size,N;
    static int[]order;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String png = ".png";
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            size = Math.min(N,50);
            order = new int[size];
            int count = 0;
            for(int i=1;i<=9;i++){
                order[count++] = i;
                count = calc(count,i);
                if(count==size) break;
            }
            sb.append("#"+t+" ");
            for(int i=0;i<size;i++){
                sb.append(order[i]).append(png).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int calc(int count,int num){
        num *= 10;
        for(int i=0;i<=9;i++){
            if(count==size || N < num + i){
                break;
            }
            if( 0 < (N / ((num + i)* 10))){
                order[count++] = num + i;
                count = calc(count, num + i);
            }else{
                order[count++] = num + i;
            }
        }
        return count;
    }
}
