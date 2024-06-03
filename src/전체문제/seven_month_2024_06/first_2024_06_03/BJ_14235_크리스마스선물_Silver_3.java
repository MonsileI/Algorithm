package 전체문제.seventh_month_2024_06.first_2024_06_03;

import java.util.*;
import java.io.*;
public class BJ_14235_크리스마스선물_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            if(num==0){
                if(pq.isEmpty()) sb.append(-1);
                else sb.append(pq.poll());
                sb.append("\n");
                continue;
            }
            for(int j=0;j<num;j++) pq.offer(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb.toString());

    }
}