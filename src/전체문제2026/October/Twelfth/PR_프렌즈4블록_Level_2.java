package 전체문제2026.October.Twelfth;

import java.util.Arrays;

public class PR_프렌즈4블록_Level_2 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[]board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m,n,board));
    }
    static int solution(int m, int n, String[] board) {
        int answer = 0;
        int N = m; int M = n;
        char[][]map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = board[i].toCharArray();
        while(true){
            boolean flag = false;
            boolean[][]check = new boolean[N][M];
            for(int i=0;i <=N-2;i++){
                for(int j=0;j<=M-2;j++){
                    if(map[i][j]!='*'){
                        boolean tmpFlag = true;
                        OuterLoop:
                        for(int l=i;l<i+2;l++){
                            for(int k=j;k<j+2;k++){
                                if(map[i][j]!=map[l][k]){
                                    tmpFlag = false;
                                    break OuterLoop;
                                }
                            }
                        }
                        if(tmpFlag){
                            flag = true;
                            for(int l=i;l<i+2;l++){
                                for(int k=j;k<j+2;k++){
                                    check[l][k] = true;
                                }
                            }
                        }
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(check[i][j]) map[i][j] = '*';
                }
            }
            //중력
            for(int j=0;j<M;j++){
                for(int i=N-1;-1<i;i--){
                    if (map[i][j] != '*') {
                        int ni = i + 1;
                        while (ni < N) {
                            if (ni == N - 1 && map[ni][j] == '*') {
                                char tmp = map[i][j];
                                map[i][j] = '*';
                                map[ni][j] = tmp;
                                break;
                            }
                            if (map[ni][j] != '*') {
                                if (ni - 1 == i) break;
                                char tmp = map[i][j];
                                map[i][j] = '*';
                                map[ni - 1][j] = tmp;
                                break;
                            }
                            ni++;
                        }
                    }
                }
            }
            if(!flag) {
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(map[i][j]=='*') answer++;
                    }
                }

                break;
            };
        }
        for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
        return answer;
    }
}
