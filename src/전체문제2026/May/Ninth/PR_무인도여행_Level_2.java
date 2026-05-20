package 전체문제2026.May.Ninth;

import java.util.*;


public class PR_무인도여행_Level_2 {
    static int N,M;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    static int[][]map;

    public static void main(String[] args) {
        String[]maps= {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }
    static  int[] solution(String[] maps) {
        int[] answer = null;
        List<Integer> list = new ArrayList<>();
        N = maps.length; M = maps[0].length();
        map  = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = maps[i];
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                if(ch=='X') map[i][j] = -1;
                else map[i][j] = ch - '0';
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j] !=-1){
                    list.add(bfs(i,j));
                }
            }
        }
        int size = list.size();
        if(size==0) answer = new int[]{-1};
        else{
            Collections.sort(list);
            answer = new int[size];
            for(int i=0;i<size;i++) answer[i] = list.get(i);
            }
        return answer;
    }
    static int bfs(int y,int x){
        int sum = map[y][x];
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]==-1) continue;
                visited[ni][nj] = true;
                sum += map[ni][nj];
                q.offer(new int[]{ni,nj});
            }
        }
        return sum;
    }
}
