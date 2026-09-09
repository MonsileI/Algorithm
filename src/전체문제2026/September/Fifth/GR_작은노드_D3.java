package 전체문제2026.September.Fifth;

import java.util.*;
import java.io.*;
public class GR_작은노드_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        boolean[]visited = new boolean[N+1];
        int answer = 1;
        visited[K] = true;
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int INF = 987654321;
        while(true){
            int minNode = INF;
            for(int next : list.get(K)){
                if(visited[next]) continue;
                if(next<minNode) minNode = next;
            }
            if(minNode!= INF){
                answer++;
                visited[minNode] = true;
                K = minNode;
            }else break;
        }
        System.out.println(answer+" "+K);
    }
}
