package 전체문제2026.March.Eighteenth;

import java.util.*;
import java.io.*;
public class BJ_1188_음식평론가_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = M - GDC(N,M);
        System.out.println(answer);
    }
    static int GDC(int N,int M) {
        return N%M == 0 ? M : GDC(M,N%M);
    }
}
