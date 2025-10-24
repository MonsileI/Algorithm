package 전체문제2025.September.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1263_시간관리_Gold_5  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N][2];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(schedules,(o1,o2) -> -(o1[1] - o2[1]));
        int end = schedules[0][1] - schedules[0][0];
        for(int i=1;i<N;i++){
            if(end > schedules[i][1]){
               end = schedules[i][1];
            }
               end -= schedules[i][0];
        }
        if(end < 1) end = -1;
        System.out.println(end);
    }
}
