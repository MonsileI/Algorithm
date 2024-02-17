package 두포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467_용액_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int L = 0 ; int R = N-1;
        int [] ans = new int [2];
        int min = Integer.MAX_VALUE;
        while(L<R){
            int sum = Math.abs(arr[L]+arr[R]);
            if(sum<=min){
                min = sum;
                ans[0] = arr[L]; ans[1] = arr[R];
            }
            if(arr[L]+arr[R]>0) R--;
            else L++;
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
}
