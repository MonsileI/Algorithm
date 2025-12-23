package 전체문제2025.December.Eight;

import java.util.*;
import java.io.*;
public class BJ_26099_설탕배달2_Silver_4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long answer = 0;
        while(true){

            if(N%5==0) {
                answer += N/5;
                break;
            }
            if(N==0) break;
            if(N<0){
                answer = -1;
                break;
            }
            answer++;
            N -= 3;
        }
        System.out.println(answer);
    }
}
