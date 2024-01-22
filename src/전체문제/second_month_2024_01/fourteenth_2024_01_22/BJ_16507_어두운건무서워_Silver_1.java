package 전체문제.second_month_2024_01.fourteenth_2024_01_22;
import java.util.*;
import java.io.*;
public class BJ_16507_어두운건무서워_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][M+1];
        int[][]sumMap = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<M+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<N+1;i++){
            int sum = 0;
            for(int j=1;j<M+1;j++){
                sum += map[i][j];
                sumMap[i][j] = sum;
            }
        }
        for(int j=1;j<M+1;j++){
            int sum = 0;
            for(int i=1;i<N+1;i++){
                sum += sumMap[i][j];
                sumMap[i][j] = sum;
            }
        }
       StringBuilder sb=  new StringBuilder();
       for(int t=0;t<Q;t++){
        st = new StringTokenizer(br.readLine()," ");
        int fi = Integer.parseInt(st.nextToken())-1;
        int fj = Integer.parseInt(st.nextToken())-1;
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        int cnt = (sj-fj) * (si-fi);
        int sum = 0 ;
        sum += sumMap[fi][fj];
        sum -= sumMap[fi][sj];
        sum -= sumMap[si][fj];
        sum += sumMap[si][sj];
        sb.append((sum/cnt)+"\n");
       }
        System.out.println(sb.toString());
    }
}
