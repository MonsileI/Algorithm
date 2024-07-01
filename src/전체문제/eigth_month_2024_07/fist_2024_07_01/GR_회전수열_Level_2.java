package 전체문제.eigth_month_2024_07.fist_2024_07_01;

import java.util.*;
import java.io.*;
public class GR_회전수열_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int value = arr[0];
        int idx = 0;
        while(M-->0){
            idx += value;
            idx %= N;
            value = arr[idx];
        }
        System.out.println(value);
    }
}
