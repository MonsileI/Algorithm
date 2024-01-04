package 전체문제.second_month_2024_01.second_2024_01_03;
import java.util.*;
import java.io.*;
public class BJ_1461_도서관_Gold_4_Re {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> posPQ = new PriorityQueue<>((o1,o2)->-(o1-o2));
        PriorityQueue<Integer> negPQ = new PriorityQueue<>((o1,o2)->-(o1-o2));
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num  = Integer.parseInt(st.nextToken());
            if(num>-1) posPQ.offer(num);
            else negPQ.offer(num*-1);
        }
        int maxVertex = 0;
        if(posPQ.isEmpty()) maxVertex = negPQ.peek();
        else if(negPQ.isEmpty()) maxVertex = posPQ.peek();
        else maxVertex = Math.max(posPQ.peek(),negPQ.peek());
        int ans = 0;

        while(!posPQ.isEmpty()){
            int tmp = posPQ.poll();
            for(int i=0;i<M-1;i++){
                posPQ.poll();
                if(posPQ.isEmpty()) break;
            }
            ans += tmp*2;
        }

        while(!negPQ.isEmpty()){
            int tmp = negPQ.poll();
            for(int i=0;i<M-1;i++){
                negPQ.poll();
                if(negPQ.isEmpty()) break;
            }
            ans += tmp*2;
        }
        ans -= maxVertex;
        System.out.println(ans);
    }
}
