package 전체문제2026.April.Seventh;

import java.util.*;
import java.io.*;
public class BJ_1263_시간관리_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][2];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[1]==o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int time = arr[N-1][1] - arr[N-1][0];
        boolean flag = true;
        for(int i=N-2;-1<i;i--){
            if(arr[i][1] < time){
                time = arr[i][1];
            }
            time -= arr[i][0];
            if(time<0){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? time : -1);

    }
}
