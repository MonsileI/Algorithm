package 전체문제.fourth_month_2024_03.third_2024_03_05;
import java.util.*;
import java.io.*;
public class BJ_2565_전깃줄_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][2];
        StringTokenizer st=  null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        int[]lis = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            lis[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j][1]<arr[i][1]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            max = Math.max(max,lis[i]);
        }
        System.out.println(N-max);
    }
}
