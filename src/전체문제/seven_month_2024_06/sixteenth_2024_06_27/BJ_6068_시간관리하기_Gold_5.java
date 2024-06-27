package 전체문제.seven_month_2024_06.sixteenth_2024_06_27;

import java.util.*;
import java.io.*;
public class BJ_6068_시간관리하기_Gold_5 {
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
        Arrays.sort(arr,(o1,o2)->-(o1[1]-o2[1]));
        int ans = arr[0][1] - arr[0][0]; //현재 시간(첫번째 일 끝냄)
        for(int i=1;i<N;i++){
            if(ans>arr[i][1]) ans = arr[i][1];
            ans -= arr[i][0];
            if(ans<0) {
                ans = -1;
                break;
            }
        }
        System.out.println(ans);

    }
}
