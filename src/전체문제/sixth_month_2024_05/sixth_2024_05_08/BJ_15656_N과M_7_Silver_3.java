package 전체문제.sixth_month_2024_05.sixth_2024_05_08;

import java.util.*;
import java.io.*;
public class  BJ_15656_N과M_7_Silver_3 {
    static int N,M;
    static int[]arr;
    static StringBuilder sb;
    static int[]tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tmp = new int[M];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        perm(0);
        System.out.println(sb.toString());
    }
    static void perm(int depth){
        if(depth==M){
            for(int i=0;i<M;i++) sb.append(tmp[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            tmp[depth] = arr[i];
            perm(depth+1);
        }
    }
}
