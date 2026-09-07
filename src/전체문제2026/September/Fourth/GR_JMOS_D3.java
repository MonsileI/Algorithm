package 전체문제2026.September.Fourth;

import java.util.*;
import java.io.*;
public class GR_JMOS_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[]lis = new int[N];
        int answer = 0;
        for(int i=0;i<N;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            answer = Math.max(answer,lis[i]);
        }
        System.out.println(N-answer);
    }
}
