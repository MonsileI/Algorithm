package 전체문제.third_month_2024_02.eighteenth_2024_02_28;
import java.util.*;
import java.io.*;
public class BJ_2457_공주님의정원_Gold_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int sm = Integer.parseInt(st.nextToken())*100;
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken())*100;
            int ed = Integer.parseInt(st.nextToken());
            arr[i][0] = sm+sd;
            arr[i][1] = em+ed;
        }
        Arrays.sort(arr,(o1,o2)->o1[0]==o2[0] ? -(o1[1]-o2[1]) : o1[0]-o2[0]);
        int max = 0;
        int cnt = 0;
        int start = 301;
        int endDay = 1201;
        int idx = 0;
        while(max<endDay){
            boolean flag =false;
            for(int i=idx;i<N;i++){
                if(start<arr[i][0]) break;
                if(max<arr[i][1]){
                    flag = true;
                    idx = i+1;
                    max = arr[i][1];
                }
            }
            if(flag){
                start = max;
                cnt++;
                continue;
            }
            break;
        }
        if(max<endDay) System.out.println(0);
        else System.out.println(cnt);
    }
}
