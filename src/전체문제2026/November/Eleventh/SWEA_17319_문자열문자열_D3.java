package 전체문제2026.November.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_17319_문자열문자열_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            boolean flag = true;
            if(N%2!=0){
                flag = false;
            }
            if(flag) {
                int j = N / 2;
                for (int i = 0; i < N / 2; i++) {
                    if (str.charAt(i) != str.charAt(j)) {
                        flag = false;
                        break;
                    }
                    j++;
                }
            }
            sb.append("#"+t);
            if(flag) sb.append(" Yes\n");
            else sb.append(" No\n");
        }
        System.out.println(sb.toString());
    }
}
