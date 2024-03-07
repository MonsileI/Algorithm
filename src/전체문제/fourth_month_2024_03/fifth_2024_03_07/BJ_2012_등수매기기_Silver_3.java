package 전체문제.fourth_month_2024_03.fifth_2024_03_07;
import java.util.*;
import java.io.*;
public class BJ_2012_등수매기기_Silver_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr =new int[N+1];
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(br.readLine());
        long ans = 0;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=1;i<N+1;i++) ans += Math.abs(arr[i]-i);
        System.out.println(ans);
    }
}
