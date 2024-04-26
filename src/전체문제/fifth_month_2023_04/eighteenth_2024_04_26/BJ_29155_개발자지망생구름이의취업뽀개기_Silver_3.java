package 전체문제.fifth_month_2023_04.eighteenth_2024_04_26;

import java.util.*;
import java.io.*;
public class BJ_29155_개발자지망생구름이의취업뽀개기_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<6;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[][]info = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(info,(o1,o2)-> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0] - o2[0]);
        int[]num = new int[6];
        int idx = 1;
        for(int i=0;i<N;i++){
            if(idx<info[i][0]) num[++idx] = i;
        }
        int ans = info[0][1]+240;
        int before = info[0][1];
        arr[1]--;
        idx = 1;
        for(int i=1;i<N;i++){
            if(arr[idx]==0){
                if(idx==5) break;
                i = num[++idx];
                before = info[i][1];
                ans += info[i][1];
                arr[idx]--;
                continue;
            }
            if(before<info[i][1]){
                ans += (info[i][1] - before);
                before = info[i][1];
            }
            ans += info[i][1];
            arr[idx]--;
        }
        System.out.println(ans);
    }
}
