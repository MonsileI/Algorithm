package 전체문제2025.December.Eleventh;

public class PR_충돌위험찾기_Level_2 {
    public static void main(String[] args) {
        int[][]points = {{2, 2},{2, 3},{2, 7},{6, 6},{5, 2}};
        int[][]routes = {{2, 3, 4, 5},{1, 3, 4, 5}};
        System.out.println(solution(points,routes));
    }
    static  int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][][]visited = new int[101][101][30000];
        int len = routes.length;
        for(int i=0;i<len;i++){
            int cp = routes[i][0] - 1; // idx에 맞추기
            int ci = points[cp][0];
            int cj = points[cp][1];
            int second = 0; //초
            for(int j=1;j<routes[i].length;j++){
                int np = routes[i][j] - 1;
                int ni = points[np][0];
                int nj = points[np][1];
                if(j!=1){
                    if (ci > ni) ci--;
                    else if (ci < ni) ci++;
                    else if (cj > nj) cj--;
                    else if (cj < nj) cj++;
                }
                while(true){
                    visited[ci][cj][second]++;
                    if (visited[ci][cj][second] == 2) {
                        answer++;
                    }
                    second++;
                    if (ci == ni && cj == nj) break;
                    if (ci > ni) ci--;
                    else if (ci < ni) ci++;
                    else if (cj > nj) cj--;
                    else if (cj < nj) cj++;
                }
                ci = ni; cj = nj;
            }
        }
        return answer;
    }
}
