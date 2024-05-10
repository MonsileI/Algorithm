package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11441_합구하기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sum = 0;
        for(int i=1;i<N+1;i++){
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            arr[i] = sum;
        }
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append((arr[b] - arr[a-1])+"\n");
        }
        System.out.println(sb.toString());
    }
}
