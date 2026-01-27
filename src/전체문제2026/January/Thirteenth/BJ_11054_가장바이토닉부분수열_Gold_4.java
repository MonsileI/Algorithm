package 전체문제2026.January.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_11054_가장바이토닉부분수열_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        int[]lDp = new int[N];
        int[]rDp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            lDp[i] = rDp[i] = 1;
        }
        int max = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    lDp[i] = Math.max(lDp[i],lDp[j]+1);
                }
            }
            max = Math.max(max,lDp[i]);
        }
        for(int i=N-1;-1<i;i--){
            for(int j=N-1;i<j;j--){
                if(arr[j]<arr[i]){
                    rDp[i] = Math.max(rDp[i],rDp[j]+1);
                }
            }
            max = Math.max(max,rDp[i]);
        }
        for(int i=0;i<N;i++){
            max = Math.max(max,(lDp[i]+rDp[i]-1));
        }
        System.out.println(max);

    }
}
