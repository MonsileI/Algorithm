package 전체문제.eigth_month_2024_07.third_2024_07_04;
import java.util.*;
import java.io.*;
public class BJ_1448_삼각형만들기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = -1;
        for(int i=N-1;1<i;i--){
            if(arr[i]<(arr[i-1]+arr[i-2])) {
                ans = arr[i] + arr[i-1] + arr[i-2];
                break;
            }
        }
        System.out.println(ans);
    }
}
