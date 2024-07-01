package 전체문제.eigth_month_2024_07.fist_2024_07_01;

import java.util.*;
import java.io.*;
public class GR_과자탑높이맞추기_Level_3 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        int min = 987564321;
        int max = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        int ans =0;
        while(true){
            boolean flag = true;
            for(int i=0;i<N;i++){
                if(arr[i]!=min){
                    flag =false;
                    break;
                }
            }
            if(flag) break;
            ans++;
            int L = min; int R = max;
            while(L<R){
                int mid = (L+R)/2;
                if(check(mid)) R = mid;
                else L = mid+1;
            }
            int tmp = 0;
            for(int i=0;i<N;i++){
                if(L<arr[i]) arr[i] = Math.max(min,L);
                tmp = Math.max(tmp,arr[i]);
            }
            max = tmp;
        }
        System.out.println(ans);
    }
    static boolean check(int mid){
        int cnt = 0;
        for(int i=0;i<N;i++){
            if(mid<arr[i]) cnt += arr[i] - mid;
            if(cnt>M) return false;
        }
        return true;
    }
}
