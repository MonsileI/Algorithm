package 전체문제.sixth_month_2024_05.ninth_2024_05_13;

import java.util.*;
import java.io.*;
public class BJ_2161_카드1_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++) q.offer(i);
        while(!q.isEmpty()){
            sb.append(q.poll()+" ");
            if(q.isEmpty()) break;
            int num = q.poll();
            q.offer(num);
        }
        System.out.println(sb.toString());
    }
}
