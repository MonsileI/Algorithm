package 전체문제2026.August.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_3421_수제버거장인_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] relation = new int[M];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                relation[i] = (1 << (a - 1)) | (1 << (b - 1));
            }
            int answer = 1;
            for(int comb = 1; comb < (1 << N); comb++) {
                boolean valid = true;

                for(int r : relation) {
                    if((comb & r) == r) {
                        valid = false;
                        break;
                    }
                }

                if(valid) answer++;
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
