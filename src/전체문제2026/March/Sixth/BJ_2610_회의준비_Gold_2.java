package 전체문제2026.March.Sixth;

import java.util.*;
import java.io.*;
public class BJ_2610_회의준비_Gold_2 {
    static boolean[]visited;
    static List<Integer> answer;
    static List<List<Integer>> list;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        answer=  new ArrayList<>();
        list = new ArrayList<>();
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[N+1];
        for(int i=1;i<N+1;i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i);
            }
        }
        System.out.println(answer);

    }
    static void bfs(int node){
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(node);
        List<Integer> tmp = new ArrayList<>();
        tmp.add(node);
        int min = node;
        int max = node;
        int[][]map = new int[N+1][N+1];
        for(int i=0;i<N+1;i++) Arrays.fill(map[i],987654321);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Integer next : list.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    map[next][cur] = map[cur][next] = 1;
                    tmp.add(next);
                    min = Math.min(min,next);
                    max = Math.max(max,next);
                    q.offer(next);
                }
            }
        }
        int ans = 0;
        int minSum = Integer.MAX_VALUE;
        for(int l=min;l<max+1;l++){
            if(!tmp.contains(l)) continue;
            int sum = 0;
            for(int i=min;i<max+1;i++) {
                for (int j = min; j < max + 1; j++) {
                    map[i][j] = Math.min(map[i][l]+map[l][j],map[i][j]);
                }
                sum += map[i][l];
            }
            if(minSum > sum){
                minSum = sum;
                ans = l;
            }
        }
        answer.add(ans);
    }
}
