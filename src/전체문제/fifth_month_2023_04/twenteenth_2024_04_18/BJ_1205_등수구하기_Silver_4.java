package 전체문제.fifth_month_2023_04.twenteenth_2024_04_18;

import java.util.*;
import java.io.*;
public class BJ_1205_등수구하기_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int tae = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N==0) System.out.println(1);
        else {
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            int idx = 1;
            int ans = -1;
            for (int i = 0; i < N; i++) {
                if (arr[i] <= tae) {
                    if(arr[i]==tae && N==P) continue;
                    if (i == N - 1 && arr[i] == tae && N==P) break;
                    ans = idx;
                    break;
                }
                idx++;
            }
            if (N < P && ans == -1) ans = N + 1;
            System.out.println(ans);
        }
    }
}
