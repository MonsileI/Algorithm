package 전체문제2026.March.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1527_금민수의개수_Silver_1 {
    static int S;
    static int E;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String tmp = st.nextToken();
        S = Integer.parseInt(tmp);
        E = Integer.parseInt(st.nextToken());

        search(0);
        System.out.println(answer);
    }
    static void search(long cur){
        if(E<cur) return;
        if(S<=cur) answer++;
        search((cur*10)+4);
        search((cur*10)+7);
    }
}
