package 전체문제2025.August.Fourth;

import java.util.*;
import java.io.*;
public class BJ_15650_N과M_2_Silver_3 {

    static int N;
    static int C;
    static int[]arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[C];
        comb(0,0);
        System.out.println(sb.toString());
    }

    static void comb(int depth, int start){

        if(depth == C){
            for(int i=0;i<C;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            arr[depth] = (i+1);
            comb(depth+1,i+1);
        }
    }
}
