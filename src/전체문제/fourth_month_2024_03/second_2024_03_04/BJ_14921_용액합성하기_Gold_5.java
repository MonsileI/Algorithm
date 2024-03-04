package 전체문제.fourth_month_2024_03.second_2024_03_04;
import java.util.*;
import java.io.*;
public class BJ_14921_용액합성하기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int L = 0 ; int R = N-1;
        int ans = -1;
        int min = 987654321;
        while(L<R){
            int diff = arr[L]+arr[R];
            if(Math.abs(diff)<min) {
                min = Math.abs(diff);
                ans = diff;
            }
            if(diff<0) L++;
            else R--;
        }
        System.out.println(ans);
    }
}
