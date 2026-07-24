package 전체문제2026.July.Eleventh;

import java.util.*;
import java.io.*;

public class SWEA_5550_나는개구리로소이다_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {

            String str = br.readLine();

            int[] frog = new int[4]; // c,r,o,a 단계에 있는 개구리 수
            int cur = 0;             // 현재 울고 있는 개구리 수
            int answer = 0;
            boolean flag = true;

            for (char ch : str.toCharArray()) {

                switch (ch) {

                    case 'c':
                        frog[0]++;
                        cur++;
                        answer = Math.max(answer, cur);
                        break;

                    case 'r':
                        if (frog[0] == 0) {
                            flag = false;
                            break;
                        }
                        frog[0]--;
                        frog[1]++;
                        break;

                    case 'o':
                        if (frog[1] == 0) {
                            flag = false;
                            break;
                        }
                        frog[1]--;
                        frog[2]++;
                        break;

                    case 'a':
                        if (frog[2] == 0) {
                            flag = false;
                            break;
                        }
                        frog[2]--;
                        frog[3]++;
                        break;

                    case 'k':
                        if (frog[3] == 0) {
                            flag = false;
                            break;
                        }
                        frog[3]--;
                        cur--;
                        break;
                }

                if (!flag) break;
            }

            if (cur != 0) answer = -1;
            if (!flag) answer = -1;

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}