package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15645_내려가기2_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]maxDp = new int[N][3];
        int[][]minDp = new int[N][3];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<3;i++) maxDp[0][i] =  minDp[0][i] =  Integer.parseInt(st.nextToken());;

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maxDp[i][0] = Math.max(maxDp[i-1][0],maxDp[i-1][1])+a;
            maxDp[i][1] = Math.max(maxDp[i-1][0],Math.max(maxDp[i-1][1],maxDp[i-1][2]))+b;
            maxDp[i][2] = Math.max(maxDp[i-1][1],maxDp[i-1][2])+c;

            minDp[i][0] = Math.min(minDp[i-1][0],minDp[i-1][1])+a;
            minDp[i][1] = Math.min(minDp[i-1][0],Math.min(minDp[i-1][1],minDp[i-1][2]))+b;
            minDp[i][2] = Math.min(minDp[i-1][1],minDp[i-1][2])+c;
        }
        System.out.print(Math.max(maxDp[N-1][0],Math.max(maxDp[N-1][1],maxDp[N-1][2]))+" ");
        System.out.print(Math.min(minDp[N-1][0],Math.min(minDp[N-1][1],minDp[N-1][2])));
    }
}
