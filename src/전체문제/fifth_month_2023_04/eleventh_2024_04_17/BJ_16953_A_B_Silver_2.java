package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_16953_A_B_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        //2를 나누거나 마지막이 1이면 지워준다.
        int ans = 1;
        if(a==b){
            ans = 0;
        }else {
            while (a != b) {
                if (b % 10 == 1) b /= 10;
                else {
                    if (b % 2 != 0) {
                        ans = -1;
                        break;
                    }
                    b /= 2;
                }
                if (b < a) {
                    ans = -1;
                    break;
                }
                ans++;
                if (a == b) break;
            }
        }
        System.out.println(ans);
    }
}
