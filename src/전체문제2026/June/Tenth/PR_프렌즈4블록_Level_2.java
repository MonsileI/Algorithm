package 전체문제2026.June.Tenth;

public class PR_프렌즈4블록_Level_2 {
    public static void main(String[] args) {
        int m =6;
        int n = 6;
        String[]board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m,n,board));
    }
    static int N,M;
    static char[][]map;
    static int[][]move = {{0,1},{1,0},{1,1}};
    static int solution(int m, int n, String[] board) {
        int answer = 0;
        N = m; M = n;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = board[i].toCharArray();
        while(true){
            //check board
            boolean flag = false;
            boolean[][]checkMap = new boolean[N][M];
            for(int i=0;i<N-1;i++){
                for(int j=0;j<M-1;j++){
                    if(map[i][j]!='*'){
                        char ch = map[i][j];
                        boolean tmpFlag= true;
                        for(int d=0;d<3;d++) {
                            int ni = i + move[d][0];
                            int nj = j + move[d][1];
                            if (map[ni][nj] != ch){
                                tmpFlag = false;
                                break;
                            }
                        }
                        if(tmpFlag){
                            flag = true;
                            checkMap[i][j] = true;
                            for(int d=0;d<3;d++){
                                int ni = i + move[d][0];
                                int nj = j + move[d][1];
                                checkMap[ni][nj] = true;
                            }
                        }
                    }
                }
            }
            if(!flag) break;
            //remove board
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(checkMap[i][j]) {
                        map[i][j] = '*';
                        answer++;
                    }
                }
            }
            //gravity
            for(int j=0;j<M;j++){
                for(int i=N-1;0<i;i--){
                    if(map[i][j]=='*'){
                        int ci = i;
                        while(-1<ci){
                            if(map[ci][j]!='*'){
                                map[i][j] = map[ci][j];
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
}
