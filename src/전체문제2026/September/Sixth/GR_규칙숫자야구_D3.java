package 전체문제2026.September.Sixth;

import java.util.*;
import java.io.*;

public class GR_규칙숫자야구_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int len = a.length();

        int[] aArr = new int[len];
        int[] bArr = new int[len];

        int[] cntA = new int[10];
        int[] cntB = new int[10];

        for (int i = 0; i < len; i++) {
            int aNum = a.charAt(i) - '0';
            int bNum = b.charAt(i) - '0';

            aArr[i] = aNum;
            bArr[i] = bNum;

            cntA[aNum]++;
            cntB[bNum]++;
        }

        int cnt = 0;

        while (true) {
            cnt++;

            boolean flag = false;
            boolean bFlag = false;

            int[] tmpBArr = new int[len];

            // 이번 단계에서 Strike였던 위치를 기억
            boolean[] strike = new boolean[len];

            for (int i = 0; i < len; i++) {

                // Strike
                if (aArr[i] == bArr[i]) {
                    strike[i] = true;
                    tmpBArr[i] = bArr[i];
                    continue;
                }

                flag = true;

                // Fail
                if (cntA[bArr[i]] == 0) {
                    int bNum = bArr[i];

                    cntB[bNum]--;

                    while (true) {
                        int tmp = (bNum + 1) % 10;

                        if (cntB[tmp] == 0) {
                            cntB[tmp]++;
                            tmpBArr[i] = tmp;
                            break;
                        }

                        bNum = tmp;
                    }
                }

                // Ball
                else {
                    tmpBArr[i] = bArr[i];
                    bFlag = true;
                }
            }

            // 이미 정답
            if (!flag) {
                break;
            }

            // 2단계 결과를 bArr에 반영
            Arrays.fill(cntB, 0);

            for (int i = 0; i < len; i++) {
                bArr[i] = tmpBArr[i];
                cntB[bArr[i]]++;
            }

            // Ball이 하나라도 있었다면 3단계
            if (bFlag) {

                /*
                 * 핵심
                 *
                 * Strike였던 위치는 고정하고,
                 * Strike가 아니었던 숫자들만 오른쪽으로 한 칸 회전
                 */

                int[] tmp = new int[len];

                int idx = 0;

                // Strike가 아닌 숫자만 모음
                for (int i = 0; i < len; i++) {
                    if (!strike[i]) {
                        tmp[idx++] = bArr[i];
                    }
                }

                // 마지막 숫자를 맨 앞으로
                int last = tmp[idx - 1];

                for (int i = idx - 1; i > 0; i--) {
                    tmp[i] = tmp[i - 1];
                }

                tmp[0] = last;

                // Strike가 아닌 위치에 다시 삽입
                idx = 0;

                for (int i = 0; i < len; i++) {
                    if (!strike[i]) {
                        bArr[i] = tmp[idx++];
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}