package 전체문제2026.February.Sixth;

import java.util.*;
import java.io.*;
public class BJ_11509_풍선맞추기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int[]dp = new int[1000001];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i=0;i<N;i++){

            if(dp[arr[i]]!=0){
                dp[arr[i]]--;
                dp[arr[i]-1]++;
            }else{
                answer++;
                dp[arr[i]-1]++;
            }
        }

        System.out.println(answer);
    }
}
