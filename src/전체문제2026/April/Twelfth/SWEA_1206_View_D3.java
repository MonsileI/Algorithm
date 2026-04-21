package 전체문제2026.April.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_1206_View_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=TC;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for (int i = 2; i < N - 2; i++) {
                int tmp = arr[i];
                int max = Math.max(Math.max(arr[i - 1], arr[i - 2]), Math.max(arr[i + 1], arr[i + 2]));
                answer += Math.max((tmp - max), 0);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
