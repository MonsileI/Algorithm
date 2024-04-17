package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1715_카드정렬하기_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ans = 0;
        for(int i=0;i<N;i++)pq.offer(Long.parseLong(br.readLine()));
        boolean flag = true;
        long value = 0;
        while(!pq.isEmpty()){
            if(flag) value = pq.poll();
            else{
                value += pq.poll();
                pq.offer(value);
                ans += value;
            }
            flag = !flag;
        }
        System.out.println(ans  );

    }
}
