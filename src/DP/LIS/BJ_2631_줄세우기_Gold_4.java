package DP.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2631_줄세우기_Gold_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr= new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        int[]lis = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            max = Math.max(max,lis[i]);
        }
        System.out.println(N-max);
    }
}
