package 전체문제.sixth_month_2024_05.thirteenth_2024_05_20;

import java.util.*;
import java.io.*;
public class BJ_1487_물건팔기_Silver_4 {
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
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        int sum = 0;
        int ans = 0;
        for(int i=0;i<N;i++){
            int tmp = 0;
            for(int j=0;j<N;j++){
                if(arr[i][0]<=arr[j][0] && 0<(arr[i][0]-arr[j][1])) tmp += (arr[i][0]-arr[j][1]);
            }
            if(sum<tmp){
                sum = tmp;
                ans = arr[i][0];
            }
        }
        System.out.println(ans);
    }
}
