package 전체문제.sixth_month_2024_05.ninth_2024_05_13;

import java.util.*;
import java.io.*;
public class BJ_14582_오늘도졌다_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] =sum;
        }
        st = new StringTokenizer(br.readLine()," ");
        int score = 0;
        boolean flag = false;
        for(int i=0;i<9;i++){
            if(arr[i]>score) {
                flag = true;
                break;
            }
            score += Integer.parseInt(st.nextToken());
        }
        System.out.println(flag ? "Yes" : "No");
    }
}
