package 전체문제2026.February.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_2751_수정렬하기2_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) pq.offer(Integer.parseInt(br.readLine()));
        StringBuilder sb=  new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}