package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_21758_꿀따기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[]sumArr = new long[N+1];
        long[]reverseArr = new long[N+1];
        int[]arr = new int[N+1];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            sumArr[i] = sum;
        }
        sum  = 0;
        for(int i=N;0<i;i--){
            sum += arr[i];
            reverseArr[i] = sum;
        }
        long max = 0;
        //벌통 오른쪽에 고정
        for(int i=2;i<N+1;i++){
            long total = (sumArr[N] - arr[i] - arr[1]) + (sumArr[N]-sumArr[i]);
            max = Math.max(max,total);
        }
        //벌통 왼쪽에 고정
        for(int i=N-1;0<i;i--){
            long total = (reverseArr[1] - arr[i] - arr[N]) + (reverseArr[1] - reverseArr[i]);
            max = Math.max(max,total);
        }
        //벌통 이동
        for(int i=2;i<N;i++){
            long total = (sumArr[i]-arr[1]) + (reverseArr[i]-arr[N]);
            max = Math.max(max,total);
        }
        System.out.println(max);
    }
}
