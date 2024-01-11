package DP.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2565_전깃줄_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1, o2) -> o1[0]-o2[0]);
        int ans = 0;
        int[]lis = new int[N];
        for(int i=0;i<N;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j][1]<arr[i][1]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            ans = Math.max(ans,lis[i]);
        }
        System.out.println(N-ans);

    }
}
