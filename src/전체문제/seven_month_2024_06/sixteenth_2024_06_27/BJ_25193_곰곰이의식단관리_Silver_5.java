package 전체문제.seven_month_2024_06.sixteenth_2024_06_27;

import java.util.*;
import java.io.*;
public class BJ_25193_곰곰이의식단관리_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int C =  0;
        String str = br.readLine();
        for(int i=0;i<N;i++) if(str.charAt(i)=='C') C++;
        N -= C;
        N++;
        int ans = C/N;
        if(C%N!=0) ans++;
        System.out.println(ans);
    }
}
