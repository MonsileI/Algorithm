package 전체문제2026.June.Sixteenth;

import java.util.*;
import java.io.*;
public class SWEA_1808_지희의고장난계산기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 10; i++) {
                char ch = st.nextToken().charAt(0);
                if (ch == '1') list.add(i);
            }
        int goal = Integer.parseInt(br.readLine());
        //붙이기, 곱하기
        }

        System.out.println(sb.toString());
    }
}
