package 전체문제2026.June.Fourth;

import java.util.*;

public class PR_빛의경로사이클_Level_2 {
    public static void main(String[] args) {
        String [] grid = {"SL","LR"};
        System.out.println(Arrays.toString(solution(grid)));
    }
    static char[][]map;
    static boolean[][][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M;
    static int[] solution(String[] grid) {
        int[] answer = {};
        //방향정보 ,
        N = grid.length;
        M = grid[0].length();
        map = new char[N][M];
        visited = new boolean[N][M][4];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) map[i] = grid[i].toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int d=0;d<4;d++){
                    if(!visited[i][j][d]){
                        visited[i][j][d] = true;
                        int cnt = calc(i,j,d);
                        list.add(cnt);
                    }
                }
            }
        }
        System.out.println(list);
        return answer;
    }
    static int calc(int i,int j, int d){
        int tmp =1;
        while(true){
             switch (map[i][j]){
                 case 'L' : d = (d+1)%4;
                break;
                 case 'R' : d = (d+3)%4;
                break;
             }
             int ni = i + move[d][0];
             int nj = j + move[d][1];
             if(ni<0){
                 ni = N-1;
             }
             if(N-1<ni){
                 ni = 0;
             }
             if(nj<0){
                 nj = M-1;
             }
             if(M-1<nj){
                 nj = 0;
             }
             if(visited[ni][nj][d]) break;
             visited[ni][nj][d] = true;
             tmp++;
             i = ni; j = nj;
        }
        return tmp;
    }
}
