package 전체문제2025.August.First;

import java.util.*;
import java.io.*;
public class BJ_1149_RGB거리_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][3];
        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        int[][] RGBArr = new int[N+1][3];
        RGBArr[0][0] = arr[0][0];
        RGBArr[0][1] = arr[0][1];
        RGBArr[0][2] = arr[0][2];

        for(int i=1;i<N;i++){
            RGBArr[i][0] = Math.min(RGBArr[i-1][1], RGBArr[i-1][2]) + arr[i][0];
            RGBArr[i][1] = Math.min(RGBArr[i-1][0], RGBArr[i-1][2]) + arr[i][1];
            RGBArr[i][2] = Math.min(RGBArr[i-1][0], RGBArr[i-1][1]) + arr[i][2];
        }
        RGBArr[N][0] = Math.min(RGBArr[N-1][1], RGBArr[N-1][2]);
        RGBArr[N][1] = Math.min(RGBArr[N-1][0], RGBArr[N-1][2]);
        RGBArr[N][2] = Math.min(RGBArr[N-1][0], RGBArr[N-1][1]);

        System.out.println(Math.min(Math.min(RGBArr[N][0],RGBArr[N][1]),RGBArr[N][2]));

    }
}
