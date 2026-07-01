package 전체문제2026.June.Eighteenth;

import java.util.*;
import java.io.*;
public class SWEA_1953_탈주범검거 {
    static int N,M;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    //1 -> 상우하좌 0 1 2 3
    //2 -> 상 하   0 2
    //3 -> 좌 우   1 3
    //4 -> 상 우   0 1
    //5 -> 우 하   1 2
    //6 -> 하 좌   2 3
    //7 -> 좌 상   3 0
    static int[][]nodesMove = {{},{0,1,2,3},{0,2},{1,3},{0,1},{1,2},{2,3},{3,0}};
    static Map<Integer,Set<Integer>> hashMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        /*
            0 -> 1,2,5,6
            1 -> 1,3,6,7
            2 -> 1,2,4,7
            3 -> 1,3,4,5
         */
        hashMap = new HashMap<>();
        hashMap.put(0,new HashSet<>());
        hashMap.put(1,new HashSet<>());
        hashMap.put(2,new HashSet<>());
        hashMap.put(3,new HashSet<>());
        hashMap.get(0).addAll(Arrays.asList(1,2,5,6));
        hashMap.get(1).addAll(Arrays.asList(1,3,6,7));
        hashMap.get(2).addAll(Arrays.asList(1,2,4,7));
        hashMap.get(3).addAll(Arrays.asList(1,3,4,5));


        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = bfs(R,C,T);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static int bfs(int y,int x,int t){
        int cnt = 1;
        Queue<int[]> q= new ArrayDeque<>();
        t--;
        q.offer(new int[]{y,x,t});
        boolean[][]visited=  new boolean[N][M];
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int time = c[2];
            if(time==0){
                continue;
            }
            int node = map[i][j];
            int[] canMove = nodesMove[node];
            for(int d=0;d<canMove.length;d++){
                int dir = canMove[d];
                int ni = i + move[dir][0];
                int nj = j + move[dir][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(hashMap.get(dir).contains(map[ni][nj])){
                    if(!visited[ni][nj]){
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj,time-1});
                        cnt++;
                    }
                }
            }
        }

        return cnt;

    }
}
