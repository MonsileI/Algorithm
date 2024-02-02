package 전체문제.third_month_2024_02.second_2024_02_02;
import java.util.*;
import java.io.*;
public class BJ_17216_가장큰감소부분수열_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[]lis = new int[N+1];
        int max = 0;
        for(int i=1;i<N+1;i++){
            lis[i] = arr[i];
            for(int j=1;j<i;j++){
                if(arr[i]<arr[j]){
                    lis[i] = Math.max(lis[i],lis[j]+arr[i]);
                }
            }
            max = Math.max(max,lis[i]);
        }
        System.out.println(max);
    }
}
