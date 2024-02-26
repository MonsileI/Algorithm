package DP.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_19118_언덕길_D5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        TC++;
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st= null;
        for(int t=1;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr = new int[N];
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            int[]lis = new int[N];
            int max = 1;
            for(int i=0;i<N;i++){
                lis[i]= 1;
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]){
                        lis[i] = Math.max(lis[i],lis[j]+1);
                    }
                }
                max = Math.max(max,lis[i]);
            }
            sb.append("#"+t+" "+(N-max)+"\n");
        }
        System.out.println(sb.toString());
    }
}
