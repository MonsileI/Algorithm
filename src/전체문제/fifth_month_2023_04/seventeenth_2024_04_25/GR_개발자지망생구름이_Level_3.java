package 전체문제.fifth_month_2023_04.seventeenth_2024_04_25;

import java.util.*;
import java.io.*;
public class GR_개발자지망생구름이_Level_3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[6];
        for(int i=1;i<6;i++)arr[i] = Integer.parseInt(st.nextToken());
        int[][]total = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            total[i][0] = Integer.parseInt(st.nextToken());
            total[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(total,(o1,o2)->o1[0]==o2[0] ? o1[1]-o2[1] : o1[0] - o2[0]);
        int ans = total[0][1];
        int level = 1;
        int before = total[0][1]; //전에 푼거
        int idx = 1; //레벨을 위한 idx
        arr[1]--; //하나풀었음
        while(true){
            if(before < total[idx][1]){
                ans += (total[idx][1]-before);
                before = total[idx][1];
            }
            ans += total[idx][1];
            arr[level]--;
            if(arr[level]==0) {
                level++;
                if(level==6) break;
                ans += 60;
                for(int i=idx;i<N;i++) {
                    if(total[i][0]==level){
                        idx = i;
                        before = total[i][1];
                        break;
                    }
                }
            }else idx++;
        }
        System.out.println(ans);
    }
}
