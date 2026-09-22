package 전체문제2026.September.Tenth;

import java.util.*;
import java.io.*;
public class GR_초콜릿포장_D2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int J = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = a*b;
        }
        Arrays.sort(arr);
        int answer = -1;
        int cnt = 0;
        for(int i=N-1;-1<i;i--){
            if(J<1){
                answer = cnt;
                break;
            }
            cnt++;
            J -= arr[i];
        }
        System.out.println(answer);
    }
}
