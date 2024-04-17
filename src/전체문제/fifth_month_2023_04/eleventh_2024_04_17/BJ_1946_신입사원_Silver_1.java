package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1946_신입사원_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            int[][]arr=  new int[N][2];
            for(int i=0;i<N;i++){
                st= new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr,(o1,o2)-> o1[0]-o2[0]);
            int ans = N;
            int min = arr[0][1];
            for(int i=1;i<N;i++){
                 if(min<arr[i][1]) ans--;
                 min = Math.min(min,arr[i][1]);
            }
            System.out.println(ans);



        }
    }
}
