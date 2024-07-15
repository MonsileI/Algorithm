package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_27377_읽씹멈춰_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int c=0;c<T;c++){
            BigInteger N = new BigInteger(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            BigInteger s = new BigInteger(st.nextToken());
            BigInteger t = new BigInteger(st.nextToken());
            BigInteger ans = new BigInteger("0");
            while (!N.equals(BigInteger.valueOf(0))) {
                if (N.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                    N = N.divide(BigInteger.valueOf(2));
                    if (N.multiply(s).compareTo(t) == 1) {
                        ans = ans.add(t);
                    } else {
                        ans = ans.add(s.multiply(N));
                    }
                } else {
                    N = N.subtract(BigInteger.valueOf(1));
                    ans = ans.add(s);
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
