package 전체문제2025.August.Seventh;

import java.util.*;
import java.io.*;
public class BJ_23971_ZOAC4_Bronze_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int CN = Integer.parseInt(st.nextToken());
        int CM = Integer.parseInt(st.nextToken());
        CN++; CM++;
        int answer = 0;

        for(int i=0;i<N;i += CN){
            for(int j=0;j<M;j += CM){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
