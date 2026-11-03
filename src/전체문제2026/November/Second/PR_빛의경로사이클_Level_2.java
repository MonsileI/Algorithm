package 전체문제2026.November.Second;

import java.util.*;

public class PR_빛의경로사이클_Level_2 {
    public static void main(String[] args) {
        String[]grid = {"S"};
        System.out.println(Arrays.toString(solution(grid)));
    }
    static boolean[][][]visited;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][]map;
    static int N,M;
    static int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        N = grid.length;
        M = grid[0].length();
        map = new char[N][M];
        visited = new boolean[N][M][4];
        for(int i=0;i<grid.length;i++) map[i] = grid[i].toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int d=0;d<4;d++){
                    if(!visited[i][j][d]){
                        int result = calc(i,j,d);
                        list.add(result);
                    }
                }
            }
        }
        Collections.sort(list);
        int size = list.size();
        int[]answer = new int[size];
        for(int i=0;i<size;i++) answer[i] = list.get(i);
        return answer;
    }
    static int calc(int y,int x,int d){
        int i = y; int j = x;
        int depth = 0;
        while(true){
            if(visited[i][j][d]) break;
            visited[i][j][d] = true;
            switch (map[i][j]){
                case 'R': d = (d+3) % 4;
                    break;
                case 'L': d = (d+1) % 4;
                    break;
            }
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(ni<0) ni= N-1;
            if(nj<0) nj = M-1;
            if(N-1<ni) ni = 0;
            if(M-1<nj) nj = 0;
            i = ni; j = nj;
            depth++;
        }
        return depth;
    }
}
