package 전체문제;

import java.util.*;
import java.io.*;
public class BJ_11728_배열합치기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int ASize = Integer.parseInt(st.nextToken());
        int BSize = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<ASize;i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<BSize;i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll());
            if(pq.isEmpty()) break;
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
