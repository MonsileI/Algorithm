package 전체문제2026.January.Second;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class BJ_1560_비숍_Silver_3  {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        if (N.compareTo(BigInteger.valueOf(3)) < 0) {
            System.out.println(N);
        } else {
            System.out.println(
            N.multiply(BigInteger.valueOf(2))
            .subtract(BigInteger.valueOf(2))
            );
        }
    }
}
