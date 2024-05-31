package 전체문제.sixth_month_2024_05.twenty_first_2024_05_31;

import java.util.*;
import java.io.*;
public class BJ_5904_Moo게임_Gold_5_Re {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int moo = 3;
        int len = 3;
        while(len<N){
            len = (len*2)  + (moo+1);
            moo++;
        }
        System.out.println(len);
        char ans = 'x';
        N--;
        while(true){
            int midIdx = (len-moo)/2;
            int lastIdx = midIdx + moo;
            if(N==midIdx){
                ans = 'm';
                break;
            }
            if(midIdx<N && N<lastIdx){
                ans = 'o';
                break;
            }
            if(lastIdx<=N){
                N -= lastIdx;
                len -= lastIdx;
            }else{
                len -= moo;
                len -= midIdx;
            }
            moo--;
        }
        System.out.println(ans);
    }
}
