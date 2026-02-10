package 전체문제2026.February.Sixth;

import java.util.*;
import java.io.*;
public class BJ_6068_시간관리하기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr=  new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->-(o1[1]-o2[1]));
        int time = arr[0][1] - arr[0][0];
        for(int i=1;i<N;i++){
            if(arr[i][1]<time) time = arr[i][1];
            time -= arr[i][0];
            if(time<0) {
                time = -1;
                break;
            }
        }
        System.out.println(time<0 ? -1 : time);

    }
}
