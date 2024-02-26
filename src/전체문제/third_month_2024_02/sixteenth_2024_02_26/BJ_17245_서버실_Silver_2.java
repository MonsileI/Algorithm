package 전체문제.third_month_2024_02.sixteenth_2024_02_26;
import java.util.*;
import java.io.*;
public class BJ_17245_서버실_Silver_2 {
    static int N;
    static int [][]map;
    static long sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map  = new int[N][N];
        int L = 0; int R = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
                R = Math.max(R,map[i][j]);
            }
        }
        while ((L+1) < R) {
            int mid = (L + R) / 2;
            long cnt = check(mid);
            if (((double)cnt/sum) >= 0.5) R = mid;
            else L = mid;
        }
        System.out.println(R);
}
    static long check(int mid){
        long tmp  = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(mid>=map[i][j]) tmp += map[i][j];
                else tmp += mid;
            }
        }
        return tmp;
    }
}
