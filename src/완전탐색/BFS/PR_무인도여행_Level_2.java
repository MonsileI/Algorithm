package 완전탐색.BFS;

import java.util.*;

public class PR_무인도여행_Level_2 {
    static boolean[][]visited;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static List<Integer> list;

    static int N,M;
    static int[] solution(String[] maps) {

        N = maps.length; M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();
        for(int i=0;i<N;i++) map[i] = maps[i].toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]!='X'){
                    visited[i][j] = true;
                    list.add(bfs(i,j));
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        Collections.sort(list);
        int [] answer=  new int [list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
    static int bfs(int y,int x){
        int cnt = Integer.parseInt(map[y][x]+"");
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int []  c= q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]!='X'){
                    visited[ni][nj] = true;
                    cnt += Integer.parseInt(map[ni][nj]+"");
                    q.offer(new int[]{ni,nj});
                }
            }
        }


        return cnt;
    }
    public static void main(String[] args) {
        /*TEST CASE
        1.
        String[]maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int result = {1,1,27};

        2.
        String[]maps = {["XXX","XXX","XXX"};
        int result = {-1};
         */
        String[]maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }
}
