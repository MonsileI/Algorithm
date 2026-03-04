package 전체문제2026.March.First;

import java.util.*;
import java.io.*;
public class BJ_20444_색종이와가위_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long l = 0; long r = N;
        long answer = -1;
        while(l<=r){
            long mid = (l+r)/2;
            long check = check(mid,N);
            if (check == K) {
                answer= check;
                break;
            }
            if (check < K)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if(answer != -1) System.out.println("YES");
        else System.out.println("NO");
    }
    static long check(long mid,int N){
        //여기서 mid의 값은 도출되는 값
        long right = mid;
        long left = N - right;
        right++; left++;
        return right * left;
    }
}
