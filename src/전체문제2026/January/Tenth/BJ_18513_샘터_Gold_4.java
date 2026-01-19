package 전체문제2026.January.Tenth;

import java.util.*;
import java.io.*;
public class BJ_18513_샘터_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            int node = Integer.parseInt(st.nextToken());
            q.offer(node);
            set.add(node);
        }
        long answer = 0;
        int dist = 1;
        OuterLoop:
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++) {
                int cur = q.poll();
                int r = cur + 1;
                int l = cur - 1;
                if (!set.contains(r)) {
                    set.add(r);
                    answer += dist;
                    q.offer(r);
                    K--;
                    if(K==0) break OuterLoop;
                }
                if (!set.contains(l)) {
                    set.add(l);
                    answer += dist;
                    q.offer(l);
                    K--;
                    if(K==0) break OuterLoop;
                }
            }
            dist++;
        }
        System.out.println(answer);
    }
}
