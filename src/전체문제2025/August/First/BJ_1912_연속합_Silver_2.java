package 전체문제2025.August.First;

import java.util.*;
import java.io.*;
public class BJ_1912_연속합_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int[]sumArr = new int[N];
        arr[0] = sumArr[0] = Integer.parseInt(st.nextToken());
        int answer = arr[0];
        for(int i=1;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + arr[i];
            answer = Math.max(answer,arr[i]);
            answer = Math.max(answer,sumArr[i]);
        }
        int min = arr[0];
        for(int i=1;i<N;i++){
            min = Math.min(min,sumArr[i-1]);
            int cur = sumArr[i];
            if(answer <= (sumArr[i] - min)){
                answer = sumArr[i] - min;
            }
        }
        System.out.println(answer);
    }
}
