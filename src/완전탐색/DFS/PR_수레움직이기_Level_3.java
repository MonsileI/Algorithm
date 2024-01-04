package 완전탐색.DFS;

public class PR_수레움직이기_Level_3 {

    static int[][]map;
    static int N;
    static int M;
    static boolean[][]redVisited;
    static boolean[][]blueVisited;
    static int rei,rej,bei,bej;
    static int answer = 987654321;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int solution(int[][] maze) {
        map = maze;
        N= maze.length; M = maze[0].length;
        int ri =0; int rj=0; int bi= 0; int bj=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1) {
                    ri = i;
                    rj = j;
                    map[i][j] = 0;
                }
                if(map[i][j]==2) {
                    bi = i;
                    bj = j;
                    map[i][j] = 0;
                }
                if(map[i][j]==3) {
                    rei= i;
                    rej = j;
                    map[i][j] = 0;
                }
                if(map[i][j]==4) {
                    bei = i;
                    bej = j;
                    map[i][j] = 0;
                }
            }
        }
        redVisited = new boolean[N][M];
        blueVisited = new boolean[N][M];
        redVisited[ri][rj] = true;
        blueVisited[bi][bj] = true;
        dfs(ri,rj,bi,bj,0,false,false);
        return answer==987654321 ? 0 : answer;
    }
    static void dfs(int ri,int rj,int bi,int bj,int cnt,boolean red, boolean blue){
        if(ri==rei && rj==rej) red = true;
        if(bi==bei && bj==bej) blue = true;
        if(red&&blue){
            answer = Math.min(answer,cnt);
            return;
        }

        for(int d=0;d<4;d++){

            int nri = ri + move[d][0]; int nrj = rj + move[d][1];

            if(!checkRange(nri,nrj)) continue;
            if(redVisited[nri][nrj]&&!red) continue;
            if(map[nri][nrj]==5) continue;
            if(red) {
                nri = ri;
                nrj = rj;
            }
            for(int dd=0;dd<4;dd++){
                int nbi = bi + move[dd][0]; int nbj = bj + move[dd][1];

                if(!checkRange(nbi,nbj)) continue;
                if(blueVisited[nbi][nbj]&&!blue) continue;
                if(map[nbi][nbj]==5) continue;
                if(blue) {
                    nbi = bi;
                    nbj = bj;
                }
                 //스위칭이면 안됨
                if((ri==nbi && rj==nbj) && (bi==nri && bj==nrj)) continue;
                //겹쳐도 안됨
                if((nri==nbi) && (nrj==nbj)) continue;
                redVisited[nri][nrj] = true;
                blueVisited[nbi][nbj] = true;
                dfs(nri,nrj,nbi,nbj,cnt+1,red,blue);
                redVisited[nri][nrj] = false;
                blueVisited[nbi][nbj] = false;
            }
        }

    }

    static boolean checkRange(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {

        /*
        TEST CASE
        int[][]maze = {{1, 4}, {0, 0}, {2, 3}};                       //result : 3
        int[][]maze = {{1, 0, 2}, {0, 0, 0}, {5, 0 ,5}, {4, 0, 3}};   //result : 7
        int[][]maze = {{1, 5}, {2, 5}, {4, 5}, {3, 5}};               //result : 0
        int[][]maze = {{4, 1, 2, 3}};                                 //result : 0
        * */
        int[][]maze = {{4, 1, 2, 3}};
        System.out.println(solution(maze));
    }
}
