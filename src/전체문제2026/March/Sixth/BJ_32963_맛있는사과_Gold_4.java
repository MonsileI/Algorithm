package 전체문제2026.March.Sixth;

import java.util.*;
import java.io.*;
public class BJ_32963_맛있는사과_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        st = new StringTokenizer(br.readLine()," ");
        int maxT = 0;
        for(int i=0;i<N;i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            maxT = Math.max(maxT,arr[i][0]);
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i][1] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr,(o1,o2)->o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int max = arr[N-1][1];
        int cnt = 1;
        int[]check = new int[N];
        for(int i=N-1;-1<i;i--){
            if(i==N-1) {
                check[i] = cnt;
                continue;
            }
            if(max==arr[i][1]) {
                cnt++;
            }else if(max<arr[i][1]){
                cnt = 1;
                max = arr[i][1];
            }
            check[i] = cnt;
        }
        StringBuilder sb=  new StringBuilder();
        for(int t=0;t<Q;t++){
            int num = Integer.parseInt(br.readLine());
            if(maxT<num) {
                sb.append(0+"\n");
                continue;
            }
            int L = 0;int R = N-1;
            while(L<R){
                int mid = (L+R)/2;
                if(arr[mid][0]<num) L = mid+1;
                else R = mid;
            }
            if(arr[L][0] < num) sb.append(0+"\n");
            else sb.append(check[L]+"\n");
        }
        System.out.println(sb.toString());
    }
}
