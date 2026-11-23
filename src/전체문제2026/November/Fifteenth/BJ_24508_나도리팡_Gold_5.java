package 전체문제2026.November.Fifteenth;


import java.io.*;
import java.util.*;

public class BJ_24508_나도리팡_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long sum = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        if (sum % K != 0) {
            System.out.println("NO");
            return;
        }

        Arrays.sort(arr);

        long total = 0;
        int count = (int)(sum / K);

        for (int i = 0; i < count; i++) {
            total += K - arr[N - 1 - i];
        }

        System.out.println(total <= T ? "YES" : "NO");
    }
}