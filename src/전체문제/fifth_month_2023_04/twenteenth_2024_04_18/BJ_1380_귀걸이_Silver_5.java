package 전체문제.fifth_month_2023_04.twenteenth_2024_04_18;

import java.util.*;
import java.io.*;
public class BJ_1380_귀걸이_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int tc = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            String[] arr = new String[N+1];
            for (int i = 1; i < N+1; i++) arr[i] = br.readLine();
            int M = (N * 2) - 1;
            boolean[] visited = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(br.readLine().split(" ")[0]);
                visited[num] = !visited[num];
            }
            for (int i = 1; i < N + 1; i++) {
                if (visited[i]) {
                    sb.append(tc+" "+arr[i]+"\n");
                    break;
                }
            }
            tc++;
        }
        System.out.println(sb.toString());
    }
}
