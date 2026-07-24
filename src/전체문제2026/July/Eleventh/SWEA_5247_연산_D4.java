package 전체문제2026.July.Eleventh;

import java.util.*;
import java.io.*;
public class SWEA_5247_연산_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<int[]> q= new ArrayDeque<>();
            Set<Integer> set=  new HashSet<>();
            set.add(a);
            q.offer(new int[]{a,0});
            int answer = 0;
            while(!q.isEmpty()){
                int[]c = q.poll();
                int num = c[0]; int cnt = c[1];
                if(num==b){
                    answer = cnt;
                    break;
                }
                if(!set.contains(num*2)) {
                    set.add(num*2);
                    q.offer(new int[]{num * 2, cnt + 1});
                }
                if(!set.contains(num-1)) {
                    set.add(num-1);
                    q.offer(new int[]{num - 1, cnt + 1});
                }
                if(!set.contains(num+1)) {
                    set.add(num+1);
                    q.offer(new int[]{num + 1, cnt + 1});
                }
                if(!set.contains(num-10)) {
                    set.add(num-10);
                    q.offer(new int[]{num - 10, cnt + 1});
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
