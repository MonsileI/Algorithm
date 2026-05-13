package 전체문제2026.May.Fourth;

import java.util.*;

public class PR_프렌즈4블록_Level_2 {
    static char[][]map;
    static int N,M;
    static int[][]move = {{0,1},{1,0},{1,1}};
    static boolean[][]visited;
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[]board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m,n,board));
    }
    static int solution(int m, int n, String[] board) {
        int answer = 0;
        N = m; M= n;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = board[i].toCharArray();

        while(true){
            boolean flag = false;
            visited = new boolean[N][M];
            //체크
            for(int i=0;i<N-1;i++){
                for(int j=0;j<M-1;j++){
                    if(map[i][j]!='*'){
                        boolean check = checkDir(i,j,true);
                        if(check){
                            visited[i][j] = true;
                            checkDir(i,j,false);
                            flag = true;
                        }
                    }
                }
            }
            if(flag==false){
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(map[i][j]=='*') answer++;
                    }
                }
                break;
            }
            //*표시
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(visited[i][j]) map[i][j] = '*';
                }
            }
            //중력
            for(int j=0;j<M;j++){
                for(int i=N-1;-1<i;i--){
                    if(map[i][j]=='*'){
                        int ci = i;
                        while(-1<ci){
                            if(map[ci][j]!='*'){
                                char tmp = map[ci][j];
                                map[i][j] = tmp;
                                map[ci][j] = '*';
                                break;
                            }
                            ci--;
                        }
                    }
                }
            }

        }
        return answer;
    }
    static boolean checkDir(int i,int j,boolean condition){
        int node = map[i][j];
        for(int d=0;d<3;d++){
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(node!=map[ni][nj]) return false;
            if(!condition) {
                visited[ni][nj] = true;
            }
        }
        return true;
    }
}
