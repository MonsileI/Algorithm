package 전체문제2025.August.Sixth;

import java.util.*;
import java.io.*;
public class BJ_1515_수이어쓰기_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int point = 0;
        int num = 0;
        OuterLoop:
        while(num++ <= 30000){
            String tmp = String.valueOf(num);
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i) == str.charAt(point)){
                    point++;
                }
                if(point == str.length()){
                    System.out.println(num);
                    break OuterLoop;
                }

            }
        }

    }
}
