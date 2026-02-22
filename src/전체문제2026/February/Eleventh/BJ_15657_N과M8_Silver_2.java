package 전체문제2026.February.Eleventh;
import java.util.*;
import java.io.*;
public class BJ_15657_N과M8_Silver_2 {
    static int N,M;
    static StringBuilder sb;
    static int[]arr;
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
        comb(0,0);
        System.out.println(sb.toString());
    }
    static void comb(int start,int depth){
        if(depth==M){
            for(int i=0;i<M;i++){
                sb.append(arr[tmp[i]]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(i,depth+1);
        }
    }
}
