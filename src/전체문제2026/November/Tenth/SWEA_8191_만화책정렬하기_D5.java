package 전체문제2026.November.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_8191_만화책정렬하기_D5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[N][2];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = i;
            }
            Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
            int answer = 1;
            int idx = arr[0][1];
            for(int i=1;i<N;i++){
                if(arr[i][1]<idx) answer++;
                idx = arr[i][1];
            }
            sb.append("#"+t+" "+answer+"\n");
        }


        System.out.println(sb.toString());
    }
}
