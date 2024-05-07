package 전체문제.sixth_month_2024_05.fifth_2024_05_07;

import java.util.*;
import java.io.*;
public class BJ_7795_먹을것인가먹힐것인가_Silver_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st =  new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int ans = 0;
            int[] nums = new int[M];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++) nums[i] = Integer.parseInt(st.nextToken());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            for(int i=0;i<M;i++){
                int L = 0; int R = N;
                int num = nums[i];
                while(L<R){
                    int mid = (L+R)/2;
                    if(arr[mid]<num) L = mid+1;
                    else R = mid;
                }
                ans += L;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());

    }
}
