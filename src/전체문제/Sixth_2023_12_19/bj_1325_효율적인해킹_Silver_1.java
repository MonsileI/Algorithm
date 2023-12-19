package 전체문제.Sixth_2023_12_19;
import java.util.*;
import java.io.*;
public class bj_1325_효율적인해킹_Silver_1 {
    static int N;
    static List<List<Integer>> list;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        int[]dist = new int[N+1];
        int max =0;
        for(int i=1;i<N+1;i++){
            bfs(i);
            dist[i] = cnt;
            max = Math.max(max,cnt);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++) if(dist[i]==max) sb.append(i+" ");
        System.out.println(sb.toString());
    }

    static void bfs(int num){
        cnt = 0;
        boolean[]visited=  new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[num] = true;
        q.offer(num);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : list.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }
    }
}