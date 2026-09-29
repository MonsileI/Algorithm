package 전체문제2026.September.Eleventh;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class GR_정사각형의개수_D1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[]dp = new BigInteger[N+1];
        dp[1] = BigInteger.ONE;
        BigInteger plusNum = new BigInteger("4");
        long rangeNum = 5;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1].add(plusNum);
            // 2. plusNum += rangeNum
            plusNum = plusNum.add(BigInteger.valueOf(rangeNum));
            // 3. rangeNum += 2
            rangeNum += 2;
        }
        System.out.println(dp[N]);
    }
}
