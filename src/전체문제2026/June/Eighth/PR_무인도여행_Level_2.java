package 전체문제2026.June.Eighth;

import java.util.*;

public class PR_무인도여행_Level_2 {
    public static void main(String[] args) {
        String[]maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }
    static int N,M;
    static int[][]map;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static  int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str = maps[i];
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                if(ch=='X') map[i][j] =-1;
                else map[i][j] = ch - '0';
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==-1) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                list.add(bfs(i,j));
            }
        }
        int size = list.size();
        if(size==0) return new int[]{-1};
        int[]answer=  new int[size];
        Collections.sort(list);
        for(int i=0;i<size;i++) answer[i] = list.get(i);
        return answer;
    }
    static int bfs(int y, int x){
        int cnt = 0;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            cnt += map[i][j];
            for(int d=0;d<4;d++){
                int ni  = i + move[d][0];
                int nj = j + move[d][1];
                if(!rangeCheck(ni,nj)) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==-1) continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj});
            }
        }
        return cnt;
    }
    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
}
