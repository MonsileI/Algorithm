package 전체문제.seven_month_2024_06.third_2024_06_05;

import java.util.*;
import java.io.*;
public class BJ_1655_가운데를말해요_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->-(o1-o2));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());

            if(i%2==0) left.offer(num);
            else right.offer(num);


            if(!left.isEmpty() && !right.isEmpty()) {
                    if (left.peek() > right.peek()) {
                        int tmp = left.poll();
                        right.offer(tmp);
                        left.offer(right.poll());
                    }
            }
            sb.append(left.peek()+"\n");
        }
        System.out.println(sb.toString());
    }
}
