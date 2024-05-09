package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11508_2plus1세일_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = 0;
        int cnt = 0;
        for(int i=N-1;-1<i;i--){
            if(cnt==2) {
                cnt = 0;
                continue;
            }
            cnt++;
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
