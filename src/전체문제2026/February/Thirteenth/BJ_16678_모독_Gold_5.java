package 전체문제2026.February.Thirteenth;
import java.util.*;
import java.io.*;
public class BJ_16678_모독_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long ans = 0;
        int idx = 1;
        for(int i=0;i<N;i++){
            if(arr[i]<idx) continue;
            if(idx<arr[i]){
                ans += arr[i]-idx;
            }
            idx++;
        }
        System.out.println(ans);
    }
}
