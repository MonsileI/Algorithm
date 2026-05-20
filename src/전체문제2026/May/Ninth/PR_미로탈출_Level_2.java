package 전체문제2026.May.Ninth;

import java.util.*;
public class PR_미로탈출_Level_2 {
    static int INF = 987654321;
    static int answer;
    static char[][]map;
    static int N,M;
    static int[][]move ={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        String[]maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }
    static int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        int si = 0; int sj = 0; int ei =0; int ej =0 ;
        int li = 0; int lj = 0;
        for(int i=0;i<N;i++){
            String str = maps[i];
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S'){
                    si = i;
                    sj = j;
                    map[i][j] = 'O';
                }
                if(map[i][j]=='E'){
                    ei = i;
                    ej = j;
                    map[i][j] = 'O';
                }
                if(map[i][j]=='L'){
                    li = i;
                    lj = j;
                    map[i][j] = 'O';
                }
            }
        }
        int f = bfs(si,sj,li,lj);
        if(f==INF) return -1;
        int s = bfs(li,lj,ei,ej);
        if(s==INF) return -1;
        answer = f + s;
        return answer;
    }
    static int bfs(int si,int sj,int ei,int ej){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        boolean[][]visited = new boolean[N][M];
        visited[si][sj] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2];
            if(i==ei&&j==ej){
                return cnt;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj]=='X') continue;
                visited[ni][nj] = true;
                q.offer(new int[]{ni,nj,cnt+1});
            }
        }

        return INF;

    }
}
