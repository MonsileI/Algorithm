package 전체문제2025.December.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_1005_ACM크래프트_Gold_3  {


    static int N;
    static int[]weight;
    static int[]depth;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(0<TC){
            TC--;
            st =  new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            weight = new int[N+1];
            depth = new int[N+1];
            st = new StringTokenizer(br.readLine()," ");
            list = new ArrayList<>();
            int []answer = new int[N+1];
            for(int i=1;i<N+1;i++) {
                weight[i] = answer[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                depth[b]++;
            }
            int Goal = Integer.parseInt(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                if(depth[i]==0){
                    q.offer(i);
                }
            }
            while(!q.isEmpty()){
                int c = q.poll();
                for(int next : list.get(c)){
                    depth[next]--;
                    answer[next] = Math.max(answer[c]+weight[next],answer[next]);
                    if(depth[next]==0) {
                        q.offer(next);
                    }
                }
            }
            sb.append(answer[Goal]+"\n");
        }
        System.out.println(sb.toString());
    }
}
