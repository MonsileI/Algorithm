package 전체문제2026.August.Fifteenth;

import java.util.*;
import java.io.*;
public class GR_학생줄세우기1_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pos = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int student = Integer.parseInt(st.nextToken());
            pos[student] = i;
        }

        int max = 1;
        int cnt = 1;

        for (int i = 2; i <= N; i++) {
            if (pos[i - 1] < pos[i]) {
                cnt++;
            } else {
                cnt = 1;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(N - max);
    }
}