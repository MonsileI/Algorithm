package 전체문제2026.July.August.Twelfth;

public class PR_사라지는발판_Level_3 {
    public static void main(String[] args) {
        int[][]board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int []aloc = {1,0};
        int []bloc = {1,2};
        System.out.println(solution(board,aloc,bloc));
    }
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N,M;
    static int solution(int[][] board, int[] aloc, int[] bloc) {
        map = board;
        N = map.length; M = map[0].length;
        int[]result = dfs(aloc,bloc);

        return result[1];
    }
    static int[] dfs(int []me, int[]opponent){
        int winRange = 26;
        int loseRange = 0;
        boolean canWin = false;
        if(map[me[0]][me[1]]==0) return new int[]{1,0}; //패배 0턴
        map[me[0]][me[1]] =0;
        int[]result = new int[2];
        boolean canMove = false;
        for(int d=0;d<4;d++){
            int ni = me[0] + move[d][0];
            int nj = me[1] + move[d][1];
            if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
            if(map[ni][nj]==0) continue;
            canMove = true;
            //순서 바뀜
            result = dfs(opponent,new int[]{ni,nj});

            //상대의 패배(나의 승리)
            if(result[0]==1){
                winRange = Math.min(winRange,result[1]);
                canWin = true;
            }else{
                loseRange = Math.max(loseRange,result[1]);
            }
        }
        map[me[0]][me[1]] =1;
        if(!canMove){
            return new int[]{1,0};
        }
        if(canWin) {
            return new int[] {0, winRange + 1}; // 내 턴(+1) 포함
        } else {
            return new int[] {1, loseRange + 1}; // 내 턴(+1) 포함
        }
    }
}
