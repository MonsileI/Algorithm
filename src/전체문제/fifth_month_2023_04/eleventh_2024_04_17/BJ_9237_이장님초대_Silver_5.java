package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_9237_이장님초대_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int day = 1;
        Arrays.sort(arr);
        int ans = 0;
        for(int i=N-1;-1<i;i--){
            ans = Math.max(ans,arr[i]+day);
            day++;
        }
        System.out.println(ans+1);
    }
}
