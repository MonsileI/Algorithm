package 전체문제2026.January.Second;

import java.util.*;
import java.io.*;

public class LC_12_IntegertoRoman_Medium {
    public static void main(String[] args) {
        /*
        I - 1 IV - 4 V-	5 IX - 9 X-	1 XL - 40
        L - 50 XC - 90 C - 100 CD - 400 D -	500
        CM - 900 M - 1000
        */
        int[]numArr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]chArr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int N = numArr.length;
        int num  =3749;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(num<numArr[i]) continue;
            int cnt = num / numArr[i];
            num -= (numArr[i]*cnt);
            for(int j=0;j<cnt;j++){
                sb.append(chArr[i]);
            }
        }

        System.out.println(sb.toString());
    }

}
