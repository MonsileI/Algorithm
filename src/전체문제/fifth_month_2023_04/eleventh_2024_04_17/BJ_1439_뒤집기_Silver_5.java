package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1439_뒤집기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[]arr = br.readLine().toCharArray();
        int N = arr.length;
        char before = arr[0];
        int zero  =0; int one = 0;
        if(before=='0') zero = 1;
        else one = 1;

        for(int i=1;i<N;i++) {
            char ch = arr[i];
            if(ch=='0'){
                if(arr[i-1]=='1')zero++;
            }else{
                if(arr[i-1]=='0')one++;
            }
        }
        System.out.println(Math.min(zero,one));
    }
}
