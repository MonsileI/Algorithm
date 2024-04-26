package 전체문제.fifth_month_2023_04.eighteenth_2024_04_26;

import java.util.*;
import java.io.*;
public class BJ_16960_스위치와램프_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lamps = new int[M + 1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int C = Integer.parseInt(st.nextToken());
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.get(i).add(num);
                lamps[num]++;
            }
        }
        boolean flag = true;
        for (int i = 1; i < M + 1; i++) {
            if (lamps[i] == 0) {
                flag = false;
                break;
            }
        }
        if (!flag) System.out.println(0);
        else {
            flag = false;
            for(int i=0;i<N;i++) {
                boolean check = true;
                for(int num : list.get(i)){
                       if(lamps[num]==1) {
                           check = false;
                           break;
                       }
                }
                if(check){
                     flag = true;
                     break;
                }
            }
            System.out.println(flag ? 1 : 0);
        }

    }
}
