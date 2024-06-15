package 전체문제.seven_month_2024_06.eighth_2024_06_15;

import java.util.*;
import java.io.*;
public class BJ_3078_좋은친구_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> [] q = new Queue[21];
        for(int i=0;i<21;i++) q[i]=new ArrayDeque<>();
        long answer = 0;
        for(int i=0;i<N;i++){
            int size = br.readLine().length();
            if(q[size].isEmpty()) q[size].offer(i);
            else{
                while(true){
                    if(i-q[size].peek()>K) q[size].poll();
                    else break;
                    if(q[size].isEmpty()) break;
                }
            answer += q[size].size();
            q[size].offer(i);
            }
        }
        System.out.println(answer);
    }
}
