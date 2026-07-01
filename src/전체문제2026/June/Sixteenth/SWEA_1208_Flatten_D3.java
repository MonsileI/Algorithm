package 전체문제2026.June.Sixteenth;

import java.util.*;
import java.io.*;
public class SWEA_1208_Flatten_D3  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb= new StringBuilder();
        int t = 1;
        while(t<11){
            int Dump = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> reversePq = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<100;i++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
                reversePq.offer(num);
            }
            while(0<Dump){
                int min = pq.poll();
                int max = reversePq.poll();
                if(min==max) break;
                pq.offer(min+1);
                reversePq.offer(max-1);
                Dump--;
            }
            int ans = reversePq.poll() - pq.poll();
            sb.append("#"+t+" "+ans+"\n");
            t++;
        }
        System.out.println(sb.toString());
    }
}
