package 전체문제.sixth_month_2023_05.first_2024_05_01;

import java.util.*;
import java.io.*;
public class BJ_1541_잃어버린괄호_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = br.readLine().split("-");
        int N = arr.length;
        int[]nums = new int[N];
        for(int i=0;i<N;i++){
             String[]tmp = arr[i].split("\\+");
             int size = tmp.length;
             int total = 0;
             for(int j=0;j<size;j++){
                 total += Integer.parseInt(tmp[j]);
             }
            nums[i] = total;
        }
        int ans = nums[0];
        for(int i=1;i<N;i++) ans -= nums[i];
        System.out.println(ans);
    }
}
