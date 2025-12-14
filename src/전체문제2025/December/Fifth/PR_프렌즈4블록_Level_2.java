package 전체문제2025.December.Fifth;
import java.util.*;
public class PR_프렌즈4블록_Level_2 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[]board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        // int answer = 14;
        System.out.println(solution(m,n,board));
    }
    static int solution(int m,int n,String[]board){
        int[][]move = {{0,1},{1,0},{1,1}};
        int N = m;
        int M = n;
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = board[i].toCharArray();
        boolean flag = false;
        int answer = 0;
        boolean[][]erase = null; //지워질 목록
        while(true){
            flag = false;
            // 1. 제거 - 제거된 항복은 X로 표시한다.
            erase = new boolean[N][M];

            for(int i=0;i<N-1;i++){
                for(int j=0;j<M-1;j++){
                    char cur = map[i][j];
                    if(cur=='X') continue;
                    boolean sFlag = true;
                    for(int d=0;d<3;d++){
                        if(cur!=map[i+move[d][0]][j+move[d][1]]){
                            sFlag = false;
                            break;
                        };
                    }
                    if(sFlag){
                        flag = true;
                        erase[i][j] = true;
                        for(int d=0;d<3;d++){
                            erase[i+move[d][0]][j+move[d][1]] = true;
                        }
                    }
                }
            }
            if(flag==false) break;
            // 2. 더해주기
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(erase[i][j]) {
                        map[i][j] = 'X';
                        answer++;
                    }
                }
            }
            // 3. 이동
            for(int i=N-1;-1<i;i--){
                for(int j=0;j<M;j++){
                    if(map[i][j]=='X'){
                        int ni = i;
                        while(true){
                            if(ni==0) break;
                            if(map[ni][j]=='X'){
                                ni -= 1;
                            }
                            if(map[ni][j]!='X'){
                                break;
                            }
                        }
                        map[i][j] = map[ni][j];
                        map[ni][j] = 'X';
                    }
                }
            }
        }

        return answer;
    }
}
