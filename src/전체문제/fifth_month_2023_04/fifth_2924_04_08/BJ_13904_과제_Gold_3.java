package 전체문제.fifth_month_2023_04.fifth_2924_04_08;

import java.util.*;
import java.io.*;
public class BJ_13904_과제_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] =  Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> -(o1[1] - o2[1]));
        boolean[]check = new boolean[1001];
        int ans = 0;
        for(int c[] : arr){
            for(int i=c[0]; i>0;i--){
                if(!check[i]){
                    check[i] = true;
                    ans += c[1];
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
