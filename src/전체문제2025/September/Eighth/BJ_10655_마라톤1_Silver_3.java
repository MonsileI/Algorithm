package 전체문제2025.September.Eighth;

import java.util.*;
import java.io.*;
public class BJ_10655_마라톤1_Silver_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        long sum  = 0;
        st = new StringTokenizer(br.readLine()," ");
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[0][1] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
        }
        int max = 0;
        for(int i=2;i<N;i++){
            int cur = Math.abs(arr[i][0] - arr[i-1][0]) + Math.abs(arr[i][1] - arr[i-1][1]);
            cur += Math.abs(arr[i-1][0] - arr[i-2][0]) + Math.abs(arr[i-1][1] - arr[i-2][1]);

            cur -= Math.abs(arr[i][0] - arr[i-2][0]) + Math.abs(arr[i][1] - arr[i-2][1]);

            max = Math.max(max,cur);
        }
        sum -= max;
        System.out.println(sum);
    }
}
