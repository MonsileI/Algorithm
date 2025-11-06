package 전체문제2025.November.First;

import java.util.*;
import java.io.*;
public class BJ_2667_단지번호붙이기_Silver_1 {
    static List<Integer> list;
    static char[][]map;
    static boolean[][]visited;
    static int N;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]=='1'){
                    visited[i][j] = true;
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb=  new StringBuilder();
        sb.append(list.size()+"\n");
        for(Integer i : list) sb.append(i+"\n");
        System.out.println(sb.toString());

    }
    static int bfs(int y,int x){
        int cnt = 1;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i  =c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj] =='1'){
                    visited[ni][nj] = true;
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return cnt;
    }
}
