package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class BJ_11866_요세푸스문제0_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb= new StringBuilder();
        sb.append("<");
        int turn = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<N+1;i++)q.offer(i);
        while(!q.isEmpty()){
            turn++;
            int num = q.poll();
            if(turn==K){
                turn = 0;
                if(q.isEmpty()) sb.append(num+">");
                else sb.append(num+", ");
            }else q.offer(num);
        }
        System.out.println(sb.toString());


    }
}
