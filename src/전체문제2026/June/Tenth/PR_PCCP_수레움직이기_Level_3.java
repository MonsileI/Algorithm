package 전체문제2026.June.Tenth;

public class PR_PCCP_수레움직이기_Level_3 {
    public static void main(String[] args) {
        int[][]maze = {{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}};
        System.out.println(solution(maze));
    }
    static int answer;
    static int N,M;
    static int rgi,rgj,bgi,bgj;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]map;
    static boolean[][]rVisited;
    static boolean[][]bVisited;
    static int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;
        //빨강 1->3 파랑 2->4
        int ri =0; int rj=0; int bi=0; int bj=0;
        N = maze.length;
        M = maze[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maze[i][j]==1){
                    ri = i; rj = j;
                    maze[i][j] = 0;
                }
                if(maze[i][j]==2){
                    bi = i; bj = j;
                    maze[i][j] = 0;
                }
                if(maze[i][j]==3){
                    rgi = i; rgj = j;
                    maze[i][j] = 0;
                }
                if(maze[i][j]==4){
                    bgi = i; bgj = j;
                    maze[i][j] = 0;
                }
            }
        }
        rVisited = new boolean[N][M];
        bVisited = new boolean[N][M];
        map = maze;
        rVisited[ri][rj] = true;
        bVisited[bi][bj] = true;
        dfs(ri,rj,bi,bj,0,false,false);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    static void dfs(int ri,int rj,int bi,int bj,int sum,boolean rFlag, boolean bFlag){
        if(ri==rgi && rj==rgj) rFlag = true;
        if(bi==bgi && bj== bgj) bFlag = true;
        if(answer<=sum) return;
        if(rFlag && bFlag) {
            answer = sum;
            return;
        }
        //조건 1. 동시에 움직인다. 2. 교차로 움직일 수 없다.
        for(int d=0;d<4;d++){
            int rni = ri + move[d][0];
            int rnj = rj + move[d][1];
            if(rFlag){
                rni = ri; rnj = rj;
            }
            if(!canMove(rni,rnj,rFlag,rVisited)) continue;
            for(int dd=0;dd<4;dd++){
                int bni = bi + move[dd][0];
                int bnj = bj + move[dd][1];
                if(bFlag){
                    bni = bi; bnj = bj;
                }
                if(!canMove(bni,bnj,bFlag,bVisited)) continue;
                if(rni==bni && rnj==bnj) continue;
                if((rni==bi && rnj==bj) && (bni == ri && bnj == rj)) continue;
                rVisited[rni][rnj] = true;
                bVisited[bni][bnj] = true;
                dfs(rni,rnj,bni,bnj,sum+1,rFlag,bFlag);
                rVisited[rni][rnj] = false;
                bVisited[bni][bnj] = false;
            }
        }
    }
    static boolean canMove(int i,int j,boolean flag,boolean[][]visited){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        if(map[i][j]==5) return false;
        if(!flag && visited[i][j]) return false;
        return true;
    }
}
