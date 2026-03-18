package 전체문제2026.March.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_2617_구슬찾기_Gold_4 {
    static List<List<Integer>> leftList;
    static List<List<Integer>> rightList;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
        for(int i=0;i<N+1;i++){
            leftList.add(new ArrayList<>());
            rightList.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            leftList.get(b).add(a); // 가벼운게 무거운걸 물고있음.
            rightList.get(a).add(b); // 무거운게 가벼운걸 물고있음.
        }

        int answer = 0;
        int middle = N/2;
        for(int i=1;i<N+1;i++){
            int left = bfs(leftList,i);
            int right = bfs(rightList,i);
            if(middle < left || middle < right) answer++;
        }
        System.out.println(answer);
    }
    static int bfs(List<List<Integer>> list, int start){
        int cnt = 0;
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(start);
        boolean[]visited = new boolean[N+1];
        visited[start] = true;
        while(!q.isEmpty()){
            int c = q.poll();
            for(Integer next : list.get(c)){
                if(!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    q.offer(next);
                }
            }
        }
        return cnt;
    }
}
