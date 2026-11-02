package 전체문제2026.November.First;

public class PR_방문길이_Level_2 {
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }
    static int solution(String dirs) {
        int answer = 0;
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        int N = 10;
        boolean[][][][]visited = new boolean[N+1][N+1][N+1][N+1];
        int i = 5; int j = 5;
        int len = dirs.length();
        for(int q=0;q<len;q++){
            char ch = dirs.charAt(q);
            int d = -1;
            switch (ch){
                case 'U' : d = 0;
                break;
                case 'R' : d = 1;
                break;
                case 'D' : d = 2;
                break;
                case 'L' : d = 3;
                break;
            }
            int ni = i + move[d][0];
            int nj = j + move[d][1];

            if(ni<0||nj<0||N<ni||N<nj) continue;
            if(!visited[ni][nj][i][j]){
                answer++;
                visited[ni][nj][i][j] = true;
                visited[i][j][ni][nj] = true;
            }
            i = ni; j = nj;
        }
        return answer;
    }
}
