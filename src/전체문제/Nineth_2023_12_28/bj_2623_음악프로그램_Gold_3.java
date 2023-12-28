package 전체문제.Nineth_2023_12_28;
import java.util.*;
import java.io.*;
public class bj_2623_음악프로그램_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]dist = new int[N+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int cnt = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt-1;j++){
                int next = Integer.parseInt(st.nextToken());
                list.get(before).add(next);
                dist[next]++;
                before = next;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) if(dist[i]==0) q.offer(i);
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node+"\n");
            cnt++;
            for(int next : list.get(node)){
                dist[next]--;
                if(dist[next]==0){
                    q.offer(next);
                }
            }
        }
        System.out.println(cnt<N ? 0 : sb.toString());
    }
}
