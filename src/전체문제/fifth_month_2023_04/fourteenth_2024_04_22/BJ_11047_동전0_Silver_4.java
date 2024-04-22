package 전체문제.fifth_month_2023_04.fourteenth_2024_04_22;

import java.util.*;
import java.io.*;
public class BJ_11047_동전0_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int[]arr= new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = 0;
        for(int i=N-1;-1<i;i--){
            if(arr[i]<=G){
                ans += (G/arr[i]);
                G %= arr[i];
                if(G==0) break;
            }
        }
        System.out.println(ans);
    }
}
