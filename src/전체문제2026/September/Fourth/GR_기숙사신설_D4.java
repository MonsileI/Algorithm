package 전체문제2026.September.Fourth;

import java.util.*;
import java.io.*;
public class GR_기숙사신설_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Q = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[]arr = new int[N+1];
        int[]sumArr = new int[N+1];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());
            sumArr[s] -= degree;
            sumArr[e] += degree;
        }
        arr[0] += sumArr[0];
        int min = arr[0]; int max = arr[0];
        for(int i=1;i<N;i++) {
            sumArr[i] += sumArr[i-1];
            arr[i] += sumArr[i];
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        System.out.println(max+"\n"+min);
    }
}
