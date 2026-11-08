package 전체문제2026.November.Fourth;

import java.util.*;

public class PR_무인도여행_Level_2 {
    public static void main(String[] args) {
        String[]maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }
    static char[][]map;
    static int N,M;
    static boolean[][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited=  new boolean[N][M];
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = maps[i].toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='X' || visited[i][j]) continue;
                list.add(bfs(i,j));
            }
        }
        int size = list.size();
        int[]answer;
        if(size==0){
            answer = new int[]{-1};
        }else{
            Collections.sort(list);
            answer = new int[size];
            for(int i=0;i<size;i++) answer[i] = list.get(i);

        }
        return answer;
    }
    static int bfs(int y,int x){
        int sum = map[y][x] - '0';
        Queue<int[]> q= new ArrayDeque<>();
        visited[y][x] = true;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c= q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(!checkRange(ni,nj)) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]=='X') continue;
                visited[ni][nj] = true;
                sum += map[ni][nj] - '0';
                q.offer(new int[]{ni,nj});
            }
        }
        return sum;
    }
    static boolean checkRange(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
}
