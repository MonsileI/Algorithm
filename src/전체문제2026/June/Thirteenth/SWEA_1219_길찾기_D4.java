package 전체문제2026.June.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1219_길찾기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int a = 0; int b= 99;
        List<List<Integer>> list;
        for(int t=1;t<=10;t++){
            st = new StringTokenizer(br.readLine()," ");
            list = new ArrayList<>();
            for(int i=0;i<=99;i++) list.add(new ArrayList<>());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
            }
            boolean[]visited = new boolean[100];
            visited[0] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(a);
            int answer = 0;
            while(!q.isEmpty()){
                int c = q.poll();
                if(c==b){
                    answer= 1;
                    break;
                }
                for(int next : list.get(c)){
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.offer(next);
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());

    }
}
