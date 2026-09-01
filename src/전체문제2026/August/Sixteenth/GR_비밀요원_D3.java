package 전체문제2026.August.Sixteenth;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class GR_비밀요원_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int len = num.length();

        BigInteger originN = new BigInteger(br.readLine());
        BigInteger N = originN;

        boolean[] isQuestionMark = new boolean[len];

        BigInteger tmp = BigInteger.ONE;
        BigInteger[] binaryNum = new BigInteger[len];

        // binaryNum[i] = 2^(len-1-i)
        for (int i = len - 1; i >= 0; i--) {
            binaryNum[i] = tmp;
            tmp = tmp.shiftLeft(1);
        }

        BigInteger answer = BigInteger.ZERO;

        // 이미 1로 정해진 비트들을 먼저 처리
        for (int i = len - 1; i >= 0; i--) {

            if (num.charAt(i) == '?') {
                isQuestionMark[i] = true;
            }

            if (num.charAt(i) == '1') {
                N = N.subtract(binaryNum[i]);
                answer = answer.add(binaryNum[i]);
            }
        }

        // ?를 큰 자리부터 가능한 만큼 1로 만든다.
        int idx = 0;

        while (N.compareTo(BigInteger.ZERO) > 0 && idx < len) {

            if (isQuestionMark[idx]) {

                if (N.compareTo(binaryNum[idx]) >= 0) {
                    N = N.subtract(binaryNum[idx]);
                    answer = answer.add(binaryNum[idx]);
                }
            }

            idx++;
        }

        // 고정된 1들만으로도 N을 초과했다면 불가능
        if (originN.compareTo(answer) < 0) {
            answer = BigInteger.valueOf(-1);
        }

        System.out.println(answer);
    }
}