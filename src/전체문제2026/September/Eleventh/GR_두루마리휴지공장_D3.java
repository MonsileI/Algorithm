package 전체문제2026.September.Eleventh;

import java.util.*;
import java.io.*;
public class GR_두루마리휴지공장_D3 {
    static int N;
    static int M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st=  new StringTokenizer(br.readLine()," ");
        int max = 0;
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        max = arr[N-1];
        long last = 0;
        for(int i=0;i<N-1;i++) last += max - arr[i];
        if(M<last){
            System.out.println("No way!");
        }else {
            M -= last;
            int answer = (M / N) + max;
            System.out.println(answer);
        }
    }
}
