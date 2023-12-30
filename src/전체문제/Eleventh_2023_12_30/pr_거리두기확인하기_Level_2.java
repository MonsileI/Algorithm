package 전체문제.Eleventh_2023_12_30;

import java.util.Arrays;

public class pr_거리두기확인하기_Level_2 {


    static int N,M;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]mMove = {{-1,1},{1,1},{1,-1},{-1,-1}};
    static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        N = places[0].length;
        M = places[0][0].length();

        for(int i=0;i<places.length;i++){
            map = new char[N][M];
            for(int y=0;y<N;y++){
                for(int x=0;x<M;x++){
                    map[y][x] = places[i][y].charAt(x);
                }
            }
            if(calc()) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    static boolean calc(){

        //맨해튼 거리가 2인데 파티션(X) 이 있을경우 ㄱㅊ
        //맨해튼 거리가 2인데 테이블이(O)이 있을 경우 ㄴㄴ
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='P'){
                    if(!check(i,j)) return false;
                }
            }
        }
        return true;

    }
    static boolean check(int i,int j){

        //거리 1,2 확인
        for(int d=0;d<4;d++){
            int ni = i + move[d][0]; int nj = j + move[d][1];
            if(!rangeCheck(ni,nj)) continue;
            if(map[ni][nj]=='P') return false;
            if(map[ni][nj]=='O'){
                int nni = ni + move[d][0]; int nnj = nj + move[d][1];
                if(!rangeCheck(nni,nnj)) continue;
                if(map[nni][nnj]=='P') return false;
            }
        }
        //대각선 확인
        for(int d=0;d<4;d++){
            int ni = i + mMove[d][0]; int nj= j + mMove[d][1];
            //0일 때, 0 1 1일때 1 2 2일때 2 3 3일때 3 0, 자기자신이랑, +1 % 4
            if(!rangeCheck(ni,nj)) continue;
            if(map[ni][nj]=='P'){
                int nni = i + move[d][0]; int nnj = j + move[d][1];
                if(rangeCheck(nni,nnj)) if(map[nni][nnj]=='O') return false;
                nni = i + move[((d+1)%4)][0]; nnj = j + move[((d+1)%4)][1];
                if(rangeCheck(nni,nnj)) if(map[nni][nnj]=='O') return false;
            }
        }
        return true;
    }

    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
    public static void main(String[] args) {
        String[][]places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }
}
