package 전체문제.sixth_month_2024_05.fourteenth_2024_05_21;

import java.util.*;
import java.io.*;
public class BJ_9576_책나눠주기_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());  //N개의 책이 있다.
            int ans = 0;
            boolean[]visited = new boolean[N+1];
            int M = Integer.parseInt(st.nextToken());
            int[][]arr = new int[M][2];
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr,(o1,o2)->o1[0]==o2[0] ? o1[1]-o2[1] : -(o1[0]-o2[0]));
            for(int i=0;i<M;i++){
                int min = arr[i][0];
                int max = arr[i][1];
                for(int j=max;min-1<j;j--){
                    if(!visited[j]){
                        visited[j] = true;
                        ans++;
                        break;
                    }
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());

    }
}
