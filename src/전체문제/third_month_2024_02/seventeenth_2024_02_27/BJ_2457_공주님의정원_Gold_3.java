package 전체문제.third_month_2024_02.seventeenth_2024_02_27;
import java.util.*;
import java.io.*;
public class BJ_2457_공주님의정원_Gold_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr = new int[N][2];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken())*100;
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken())*100;
            int endDay = Integer.parseInt(st.nextToken());
            arr[i][0] = startMonth+startDay;
            arr[i][1] = endMonth+endDay;
        }
        Arrays.sort(arr,(o1,o2)-> o1[0]==o2[0] ? -(o1[1]-o2[1]) : o1[0]-o2[0]);
        int endDay = 1201;
        int start = 301;
        int count = 0;
        int max = 0;
        int idx = 0;
        while(start<endDay){
            boolean flag = false;
            for(int i=idx;i<N;i++){
                if(start<arr[i][0]) break;
                if(max<arr[i][1]){
                    max = arr[i][1];
                    flag = true;
                    idx = i+1;
                }
            }
            if(flag){
                count++;
                start = max;
                continue;
            }
            break;
        }
        if(max<endDay) System.out.println(0);
        else System.out.println(count);

    }
}
