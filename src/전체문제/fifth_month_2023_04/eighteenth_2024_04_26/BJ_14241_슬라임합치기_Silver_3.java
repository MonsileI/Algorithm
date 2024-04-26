package 전체문제.fifth_month_2023_04.eighteenth_2024_04_26;

import java.util.*;
import java.io.*;
public class BJ_14241_슬라임합치기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int ans = 0;
        int now = arr[N-1];
        for(int i=N-2;-1<i;i--){
            ans += (now * arr[i]);
            now += arr[i];
        }
        System.out.println(ans);
    }
}
