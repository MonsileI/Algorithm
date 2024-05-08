package 순열_조합_부분집합.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15656_N과M_7_Silver_3 {
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
