package 두포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
