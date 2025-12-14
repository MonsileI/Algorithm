package 전체문제2025.December.Fifth;

import java.util.*;
import java.io.*;
public class BJ_1005_ACMCraft_Gold_3 {
    static int N,K;
    static int [] edgeCount;
    static int [] dist;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        while(0<T){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            edgeCount = new int[N+1];

            dist = new int[N+1];
            list = new ArrayList<>();
            int[]answer=  new int[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++) {
                dist[i] = answer[i] =  Integer.parseInt(st.nextToken());
                list.add(new ArrayList<>());
            }
            list.add(new ArrayList<>());

            for(int i=0;i<K;i++){
                st= new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                edgeCount[to]++;
            }
            int W = Integer.parseInt(br.readLine()); //이걸 지어야 승리!
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1;i<N+1;i++){
                if(edgeCount[i]==0) q.offer(i);
            }
            while(!q.isEmpty()){
                int c = q.poll();
                for(int next : list.get(c)){
                    edgeCount[next]--;
                    answer[next] = Math.max(answer[c]+dist[next],answer[next]);
                    if(edgeCount[next]==0){
                        q.offer(next);
                    }
                }
            }
            sb.append(answer[W]+"\n");
            T--;
        }
        System.out.println(sb.toString());
    }
}
