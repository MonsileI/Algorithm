package 전체문제2025.September.Eighth;

import java.util.*;
import java.io.*;
public class BJ_2138_전구와스위치_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        String A = br.readLine(); String B = br.readLine();
        boolean[]arrA = new boolean[N];
        boolean[]arrB = new boolean[N];
        for(int i=0;i<N;i++){
            if(A.charAt(i)=='1') arrA[i] = true;
            if(B.charAt(i)=='1') arrB[i] = true;
        }

        int answer = calc(arrA,arrB);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    static int calc(boolean[]arrA,boolean[]arrB){
        int N = arrA.length;
        //arrA -> 현재상태, 목표 -> arrB
        boolean[]tmp1 = new boolean[N];
        boolean[]tmp2 = new boolean[N];
        for(int i=0;i<N;i++) tmp1[i] = tmp2[i] = arrA[i];

        int aCnt = 1;
        int bCnt = 0;
        tmp1[0] = !tmp1[0];
        tmp1[1] = !tmp1[1];
        for(int i=0;i<N-1;i++){
            if(tmp1[i] != arrB[i]){
                aCnt++;
                tmp1[i] = !tmp1[i];
                tmp1[i+1] = !tmp1[i+1];

                if(i!=N-2){
                    tmp1[i+2] = !tmp1[i+2];
                }
            }
            if(tmp2[i] != arrB[i]){
                bCnt++;
                tmp2[i] = !tmp2[i];
                tmp2[i+1] = !tmp2[i+1];

                if(i!=N-2){
                    tmp2[i+2] = !tmp2[i+2];
                }
            }
        }
        boolean flagA = true;
        boolean flagB = true;
        for(int i=0;i<N;i++){
            if(tmp1[i] != arrB[i]){
                flagA = false;
            }
            if(tmp2[i] != arrB[i]){
                flagB = false;
            }
        }

        if(!flagA) aCnt = Integer.MAX_VALUE;
        if(!flagB) bCnt = Integer.MAX_VALUE;

        return Math.min(aCnt,bCnt);
    }
}
