package 전체문제2026.January.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_13398_연속합_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        int []LDP = new int[N];
        int []RDP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        LDP[0] = arr[0];
        int max = arr[0];
        for(int i=1;i<N;i++){
            LDP[i] = Math.max(LDP[i-1]+arr[i],arr[i]);
            max = Math.max(max,LDP[i]);
        }
        RDP[N-1] = arr[N-1];
        for(int i=N-2;-1<i;i--) RDP[i] = Math.max(RDP[i+1]+arr[i],arr[i]);
        for(int i=1;i<N-1;i++){
            max = Math.max(max,LDP[i-1]+RDP[i+1]);
        }
        System.out.println(max);
    }
}
