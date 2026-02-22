package 전체문제2026.February.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_3649_로봇프로젝트_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str==null || str.equals("")) break;
            int H = Integer.parseInt(str);
            H *= 10000000;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            int L = 0;
            int R = N - 1;
            int diff = Integer.MIN_VALUE;
            int[] answer = {-1, -1};
            while (L <= R) {
                int sum = arr[L] + arr[R];
                if (sum < H) {
                    L++;
                } else {
                    if (sum == H) {
                        if (diff < Math.abs(arr[L] - arr[R])) {
                            diff = Math.abs(arr[L] - arr[R]);
                            answer[0] = L;
                            answer[1] = R;
                        }
                    }
                    R--;
                }
            }
            if (answer[0] == -1) {
                sb.append("danger");
            } else {
                sb.append("yes " + arr[answer[0]] + " " + arr[answer[1]]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
