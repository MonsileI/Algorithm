package 전체문제2026.November.Ninteenth;

import java.util.*;
import java.io.*;
public class BJ_30088_공포의면담실_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        long[]arr = new long[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            for(int j=0;j<M;j++){
                arr[i] += Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr);
        for(int i=1;i<N;i++) arr[i] += arr[i-1];
        long answer = 0;
        for(int i=0;i<N;i++) answer += arr[i];
        System.out.println(answer);
    }
}