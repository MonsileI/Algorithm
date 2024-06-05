package 전체문제.seven_month_2024_06.third_2024_06_05;

import java.util.*;
import java.io.*;
public class BJ_2292_벌집_Bronze_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int room = 1;
        int plus = 0;
        int cnt = 1;
        while(true){
            if(room>=num) break;
            plus += 6;
            room += plus;
            cnt++;
        }
        System.out.println(cnt);
    }
}